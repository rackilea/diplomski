SearchRequestBuilder builder= client.prepareSearch(index)
            .setType(type)
            .addFacet(facet)
            .setFields("_timestamp")          <--- add this line
            .setFrom(start)
            .setSize(limit);
SearchResponse response = builder.execute().actionGet();