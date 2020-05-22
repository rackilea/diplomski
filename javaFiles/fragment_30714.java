"aggregations" : {
    "byDevice" : {
      "doc_count_error_upper_bound" : 0,
      "sum_other_doc_count" : 0,
      "buckets" : [
        {
          "key" : "VFD 720",
          "doc_count" : 3,
          "byDate" : {
            "doc_count_error_upper_bound" : 0,
            "sum_other_doc_count" : 0,
            "buckets" : [
              {
                "key" : "2019-06-06",
                "doc_count" : 2,
                "byHours" : {
                  "doc_count_error_upper_bound" : 0,
                  "sum_other_doc_count" : 0,
                  "buckets" : [
                    {
                      "key" : "12",
                      "doc_count" : 1
                    },
                    {
                      "key" : "15",
                      "doc_count" : 1
                    }
                  ]
                }
              },
              {
                "key" : "2019-06-05",
                "doc_count" : 1,
                "byHours" : {
                  "doc_count_error_upper_bound" : 0,
                  "sum_other_doc_count" : 0,
                  "buckets" : [
                    {
                      "key" : "12",
                      "doc_count" : 1
                    }
                  ]
                }
              }
            ]
          }
        },
        {
          "key" : "VFD 721",
          "doc_count" : 2,
          "byDate" : {
            "doc_count_error_upper_bound" : 0,
            "sum_other_doc_count" : 0,
            "buckets" : [
              {
                "key" : "2019-06-05",
                "doc_count" : 1,
                "byHours" : {
                  "doc_count_error_upper_bound" : 0,
                  "sum_other_doc_count" : 0,
                  "buckets" : [
                    {
                      "key" : "12",
                      "doc_count" : 1
                    }
                  ]
                }
              },
              {
                "key" : "2019-06-06",
                "doc_count" : 1,
                "byHours" : {
                  "doc_count_error_upper_bound" : 0,
                  "sum_other_doc_count" : 0,
                  "buckets" : [
                    {
                      "key" : "12",
                      "doc_count" : 1
                    }
                  ]
                }
              }
            ]
          }
        }
      ]
    }
  }