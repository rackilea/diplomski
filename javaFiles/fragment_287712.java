SearchQuery searchQuery = new NativeSearchQueryBuilder().withIndices(indexName)
        .withTypes(typeName)
        .withQuery(queryBuilder)
        .withPageable(pageable)
        .build();
SearchResult result = template.query(searchQuery, new ResultsExtractor<SearchResult>() {

    @Override
    public SearchResult extract(SearchResponse response) {
        long totalHits = response.getHits()
                .totalHits();
        List<String> ids = new ArrayList<String>();
        for (SearchHit hit : response.getHits()) {
            if (hit != null) {
                ids.add(hit.getId());
            }
        }
        return new SearchResult(ids, totalHits);
    }
});
System.out.println(result.getIds());
System.out.println(result.getCount());