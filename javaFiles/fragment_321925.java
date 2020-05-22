SearchResponse response = client.prepareSearch("cn_*")
                       .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                        .setFrom(0).setSize(10).setExplain(true)
                        .setPostFilter(FilterBuilders.rangeFilter("@timestamp").from(TIMESTAMP_FROM).to(TIMESTAMP_TO))
                        .setFetchSource(new String[]{"ether_stat_s"}, null)
                        .execute()
                       .actionGet();