SearchRequestBuilder requestBuilder = client.prepareSearch("crawlbot").setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
queryBuilder.must(QueryBuilders.termQuery("article.url", e.getKey().getUrl()));
...                                 ^
                                    |
                        use a term query instead