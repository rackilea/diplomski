Client client;
try {
    client = TransportClient.builder().build().
            addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

    QueryBuilder qb = QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("user_agent", ""));
    SearchResponse scrollResp = client.prepareSearch("demo_risk_data")
        .addSort(SortParseElement.DOC_FIELD_NAME, SortOrder.ASC)
        .setScroll(new TimeValue(60000))
        .setQuery(qb)
        .setSize(100).execute().actionGet();

    //Scroll until no hits are returned
    while (true) {
        //Break condition: No hits are returned
        if (scrollResp.getHits().getHits().length == 0) {
            break;
        }

        // otherwise read results
        for (SearchHit hit : scrollResp.getHits().getHits()) {
            JSONObject value = new JSONObject(searchData.getSource());
            System.out.println(value.toString());
        }

        // prepare next query
        scrollResp = client.prepareSearchScroll(scrollResp.getScrollId()).setScroll(new TimeValue(60000)).execute().actionGet();
    }
}