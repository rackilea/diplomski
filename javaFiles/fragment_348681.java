SearchResponse searchResponse = searchRequestBuilder.execute().actionGet()
    StringTerms stringTerms = searchResponse?.getAggregations()?.getAsMap()?.get("topCategoryFilter")
    List<StringTerms.Bucket> bucketList = stringTerms?.getBuckets()
    for(StringTerms.Bucket bucket :bucketList){
        String key = bucket.getKey()
        Integer doc_count = (Integer)bucket.getDocCount()
    }