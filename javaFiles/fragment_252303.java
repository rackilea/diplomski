import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.HasChildQueryBuilder;
import org.elasticsearch.index.query.HasParentQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermFilterBuilder;

public class ParentChildQueryExample {

  public static void main(String args[]) throws InterruptedException, ExecutionException {

    //Set the Transport client which is used to communicate with your ES cluster. It is also possible to set this up using the Client Node.
    Settings settings = ImmutableSettings.settingsBuilder()
        .put("cluster.name", "elasticsearch").build();
    Client client = new TransportClient(settings)
        .addTransportAddress(new InetSocketTransportAddress(
        "localhost",
        9300));

    //create the searchRequestBuilder object.
    SearchRequestBuilder searchRequestBuilder = new SearchRequestBuilder(client).setIndices("test");

    //Query 1. Search on all books that have the term 'book' in the title and return the 'authors'.
    HasChildQueryBuilder bookNameQuery = QueryBuilders.hasChildQuery("book", QueryBuilders.matchQuery("name", "book"));
    System.out.println("Exectuing Query 1");
    SearchResponse searchResponse1 = searchRequestBuilder.setQuery(bookNameQuery).execute().actionGet();
    System.out.println("There were " + searchResponse1.getHits().getTotalHits()  + " results found for Query 1.");
    System.out.println(searchResponse1.toString());
    System.out.println();

    //Query 2. Search on all authors that have the terms 'jon doe' in the name and return the 'books'.
    HasParentQueryBuilder authorNameQuery = QueryBuilders.hasParentQuery("author", QueryBuilders.matchQuery("name", "jon doe"));
    System.out.println("Exectuing Query 2");
    SearchResponse searchResponse2 = searchRequestBuilder.setQuery(authorNameQuery).execute().actionGet();
    System.out.println("There were " + searchResponse2.getHits().getTotalHits()  + " results found for Query 2.");
    System.out.println(searchResponse2.toString());
    System.out.println();

    //Query 3. Search for books written by 'jane smith' and type Fiction.
    TermFilterBuilder termFilter = FilterBuilders.termFilter("category.raw", "Fiction");
    HasParentQueryBuilder authorNameQuery2 = QueryBuilders.hasParentQuery("author", QueryBuilders.matchQuery("name", "jane smith"));
    SearchResponse searchResponse3 = searchRequestBuilder.setQuery(QueryBuilders.filteredQuery(authorNameQuery2, termFilter)).execute().actionGet();
    System.out.println("There were " + searchResponse3.getHits().getTotalHits()  + " results found for Query 3.");
    System.out.println(searchResponse3.toString());
    System.out.println();
  }
}