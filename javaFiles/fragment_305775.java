final SearchResponse sr = client
            .prepareSearch("index")
            .setTypes("docType")
            .setSearchType(SearchType.COUNT)
            .addAggregation(AggregationBuilders.terms("aggName").field("fieldName"))
            .execute()
            .actionGet();

        System.out.println(sr);