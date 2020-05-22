package com.example.plugins.tutorial;

import com.atlassian.jira.util.collect.MapBuilder;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.IssueFactory;
import com.atlassian.jira.issue.search.SearchException;
import com.atlassian.jira.issue.search.SearchProviderFactory;
import com.atlassian.jira.issue.search.SearchRequest;
import com.atlassian.jira.issue.views.util.IssueWriterHitCollector;
import com.atlassian.jira.plugin.searchrequestview.AbstractSearchRequestView;
import com.atlassian.jira.plugin.searchrequestview.SearchRequestParams;
import com.atlassian.jira.security.JiraAuthenticationContext;
import com.atlassian.jira.util.JiraVelocityUtils;
import com.atlassian.jira.issue.search.SearchProvider;

import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Collector;

import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NextTestSearch extends AbstractSearchRequestView {

private final JiraAuthenticationContext authenticationContext;
private final SearchProviderFactory searchProviderFactory;
private final IssueFactory issueFactory;
private final SearchProvider searchProvider;

public NextTestSearch(JiraAuthenticationContext authenticationContext, SearchProviderFactory searchProviderFactory,
        IssueFactory issueFactory, SearchProvider searchProvider)
{
    this.authenticationContext = authenticationContext;
    this.searchProviderFactory = searchProviderFactory;
    this.issueFactory = issueFactory;
    this.searchProvider = searchProvider;
}

@Override
public void writeSearchResults(final SearchRequest searchRequest,final SearchRequestParams searchRequestParams,final Writer writer) throws SearchException 
{
    final Map defaultParams = JiraVelocityUtils.getDefaultVelocityParams(authenticationContext);
    final Map headerParams = new HashMap(defaultParams);
    headerParams.put("filtername", searchRequest.getName());
    headerParams.put("user", authenticationContext.getLoggedInUser());
    try 
    {
        //Header
        writer.write(descriptor.getHtml("header", headerParams));
        //Body
        final IndexSearcher searcher = searchProviderFactory.getSearcher(SearchProviderFactory.ISSUE_INDEX);        
        final Map issueParams = new HashMap(defaultParams);
        final Collector hitCollector = new IssueWriterHitCollector(searcher, writer, issueFactory) 
        {
            protected void writeIssue(Issue issue, Writer writer) throws IOException 
            {
                //put the current issue into the velocity context and render the single issue view
                issueParams.put("issue", issue);
                writer.write(descriptor.getHtml("body", issueParams));
            }
        };
        searchProvider.searchAndSort(searchRequest.getQuery(), authenticationContext.getLoggedInUser(), hitCollector, searchRequestParams.getPagerFilter());
        //Footer
        writer.write(descriptor.getHtml("footer", MapBuilder.build("user", authenticationContext.getLoggedInUser())));
    }
    catch (IOException e) 
    {
        throw new RuntimeException(e);
    }
    catch (SearchException e) 
    {
        throw new RuntimeException(e);
    }
}
}