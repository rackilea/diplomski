SearchResponse response = client.search(new SearchRequest("student")
    .source(new SearchSourceBuilder()
            .size(0)
            .aggregation(
                    AggregationBuilders.terms("by_name").field("name.keyword")
                            .subAggregation(AggregationBuilders.terms("by_id")
                                    .field("id")
                            )
            );