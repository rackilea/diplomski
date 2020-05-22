import static org.apache.commons.lang.StringUtils.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.compass.core.CompassQuery;
import org.compass.core.engine.SearchEngineException;
import org.compass.core.engine.SearchEngineQuery;
import org.compass.core.impl.DefaultCompassQuery;
import org.compass.core.lucene.engine.LuceneSearchEngineQuery;
import org.compass.core.lucene.engine.queryparser.QueryParserUtils;

public class SearchTermExtractor {

public String extract(CompassQuery compassQuery, final String fieldName) {
    SearchEngineQuery searchEngineQuery = ((DefaultCompassQuery)compassQuery).getSearchEngineQuery();
    Query luceneQuery = ((LuceneSearchEngineQuery)searchEngineQuery).getQuery();

    final List<String> suggestedTerms = new ArrayList<String>();

    // Use a visitor to extract the terms
    QueryParserUtils.visit(luceneQuery, new QueryParserUtils.QueryTermVisitor() {
        @Override
        public Term replaceTerm(Term term) throws SearchEngineException {
            if (fieldName.equals(term.field())) {
                suggestedTerms.add(term.text());
            }
            // Just return the original term, we're not trying to modify the query itself
            return term;
        }
    });

    return join(suggestedTerms, ' '); // join is from Commons Lang StringUtils
}

}