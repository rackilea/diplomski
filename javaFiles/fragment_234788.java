"query": {
 "filtered": {
   "query":{
     "bool" {
        "must": {
          "query_string": {
              "query": "foo"
          }
      },
      "should": {
          // deferred
      }
    }
  },
  "filter" : {
    "term": {"size": "m"}
  }
 }
}