import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.QueryBuilders.*;

SearchResponse response = client.prepareSearch("your_index_goes_here")
    .setTypes("YourTypeGoesHere")
    .setQuery(QueryBuilders.termQuery("some_field", "some_value"))
    .setSize(0) // Don't return any documents, we don't need them.
    .get();

SearchHits hits = response.getHits();
long hitsCount = hits.getTotalHits();