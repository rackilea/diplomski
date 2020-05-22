"hits" : {
 "total" : {
      "value" : 1,
      "relation" : "eq"
    },
    "max_score" : 1.0,
    "hits" : [
      {
        "_index" : "my_index",
        "_type" : "_doc",
        "_id" : "1",
        "_score" : 1.0,
        "_source" : {
          "text" : "This is a good thing for versions before 3.2 but bad for 3.5 and later"
        }
      }
    ]
  }