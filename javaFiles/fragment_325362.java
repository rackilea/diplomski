public class TestRepositoryImpl implements TestRepositoryCustom
{
    Page<Test> findByCustom(Pageable pageable, ...)
    {
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();
        FilterBuilder filter = FilterBuilders.staticMethodsToBuildFilters;
        /*
         * Your code here to setup your query
        */

        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder().withQuery(boolQuery).withFilter(filter).withPageable(pageable); 

        //These two are the crucial elements that will allow the search to look up based on alias
        builder.withIndices("test-alias");
        builder.withTypes("test");

        //Execute the query
        SearchQuery searchQuery = builder.build();
        return elasticSearchTemplate.queryForPage(searchQuery, Test.class);
    }
}