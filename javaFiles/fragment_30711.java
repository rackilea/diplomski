"aggregations" : {
    "distinct_hours" : {
      "value" : 2
    },
    "byHours" : {
      "doc_count_error_upper_bound" : 0,
      "sum_other_doc_count" : 0,
      "buckets" : [
        {
          "key" : "12",
          "doc_count" : 2
        },
        {
          "key" : "1",
          "doc_count" : 1
        }
      ]
    }
  }