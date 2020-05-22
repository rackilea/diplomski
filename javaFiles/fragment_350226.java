GET student/_search
{
  "size": 0,
  "aggs": {
    "name": {
      "terms": {
        "field": "name.keyword",
        "size": 10
      },"aggs": {
        "id": {
          "terms": {
            "field": "id",
            "size": 10
          }
        }
      }
    }
  }
}