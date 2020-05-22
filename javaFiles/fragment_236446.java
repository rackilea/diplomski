curl -XGET 'http://localhost:9200/myindex/mydata/_search?search_type=count&pretty' -d '
> {
>  "query" : {
>     "match_all" : { } 
>   },
>     "aggs" : {
>         "date_hist_agg" : {
>             "date_histogram" : {"field" : "timestamp", "interval" : "hour"},
>             "aggs" : {
>              "status_agg" : {
>                 "terms" : { "field" : "status" }
>             }
>           }
>        }     
>      }
> }'
{
  "took" : 213,
  "timed_out" : false,
  "_shards" : {
    "total" : 5,
    "successful" : 5,
    "failed" : 0
  },
  "hits" : {
    "total" : 3,
    "max_score" : 0.0,
    "hits" : [ ]
  },
  "aggregations" : {
    "date_hist_agg" : {
      "buckets" : [ {
        "key_as_string" : "2014-12-23T17:00:00.000Z",
        "key" : 1419354000000,
        "doc_count" : 2,
        "status_agg" : {
          "doc_count_error_upper_bound" : 0,
          "sum_other_doc_count" : 0,
          "buckets" : [ {
            "key" : "active",
            "doc_count" : 1
          }, {
            "key" : "paused",
            "doc_count" : 1
          } ]
        }
      }, {
        "key_as_string" : "2014-12-23T18:00:00.000Z",
        "key" : 1419357600000,
        "doc_count" : 1,
        "status_agg" : {
          "doc_count_error_upper_bound" : 0,
          "sum_other_doc_count" : 0,
          "buckets" : [ {
            "key" : "active",
            "doc_count" : 1
          } ]
        }
      } ]
    }
  }
}