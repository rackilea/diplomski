SearchResponse response = esClient.prepareMoreLikeThis("auction", "product", productId)
            .setSearchSize(size)
            .setField("name")
            .setMinDocFreq(0)
            .setMinTermFreq(1)
            .setMinWordLen(2)
            .setSearchSource(query)
            .execute().actionGet();