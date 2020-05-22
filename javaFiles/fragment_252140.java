SearchResponse response=
                client.prepareSearch("your_index_name_here").setQuery(QueryBuilders.filteredQuery(QueryBuilders.matchAllQuery(),
                FilterBuilders.andFilter(
                        FilterBuilders.termFilter("server","x"),
                        FilterBuilders.termFilter("dt_time","x")
                ))).addAggregation(
                AggregationBuilders.terms("dt_timeaggs").field("dt_time").size(100).subAggregation(
                        AggregationBuilders.terms("cpu_aggs").field("cpu").size(100)
                )
        ).setSize(0).get();