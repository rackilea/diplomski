{
    "took" : 130,
    "timed_out" : false,
    "_shards" : {
        "total" : 5,
        "successful" : 5,
        "failed" : 0
    },
    "hits" : {
        "total" : 1927227,
        "max_score" : 0.0,
        "hits" : [ ]
    },
    "aggregations" : {
        "aggName" : {
            "doc_count_error_upper_bound" : 0,
            "sum_other_doc_count" : 0,
            "buckets" : [ {
                "key" : "key1",
                "doc_count" : 757843
            }, {
                "key" : "key2",
                "doc_count" : 620033
            }, {
                "key" : "key3",
                "doc_count" : 549351
            } ]
        }
    }
}