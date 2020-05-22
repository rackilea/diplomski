// 2. bootstrap the query
SearchRequestBuilder search = client.prepareSearch("student")
    .setSize(0).setFrom(0)
    .setQuery(QueryBuilders.matchAllQuery());

// 3. add a stats aggregation for each of your fields

TermsAggregationBuilder aggregation = AggregationBuilders.terms("name_stats").field("name.keyword");
aggregation.subAggregation(AggregationBuilders.terms("id_stats").field("id"));  
search.aggregation(aggregation);


// 4. execute the query
SearchResponse response = search.execute().actionGet();


    Terms termAgg = (Terms)response.getAggregations().get("name_stats");

    for (Terms.Bucket entry: termAgg.getBuckets()) {
        if (entry.getDocCount() != 0) {
            Terms terms =entry.getAggregations().get("id");
            Collection<Terms.Bucket> buckets = terms.getBuckets();
            for (Bucket sub : buckets ) {
                System.out.println((int) sub.getDocCount());
                System.out.println(sub.getKeyAsString());
            }
        }
    }