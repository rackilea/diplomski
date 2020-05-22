{
    "_scroll_id" : "scrollId",
    "took" : 1000,
    "timed_out" : false,
    "_shards" : {
        "total" : 1,
        "successful" : 1,
        "failed" : 0
    },
    "hits" : {
        "total" : 28,
        "max_score" : 0.2345,
        "hits" : [ {
            "_index" : "monitoring",
            "_type" : "quota-management",
            "_id" : "5YmRf-6OTvelt29V5dphmw",
            "_score" : 0.2345,
            "_source":{"@timestamp":"2014-08-20T15:43:20.762Z","category_name":"cat1111","alert_message":"the new cpu threshold has been reached 80%","alert_type":"Critical","view_mode":"unread"}
        } ]
    }
}