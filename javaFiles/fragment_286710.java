{
  "size": 0,
  "aggs": {
    "by_version": {
      "terms": {
        "field": "version_number"
      },
      "aggs": {
        "max_date": {
          "top_hits": {
            "size": 1,
            "sort": {
              "indexDate": "desc"
            },
            "_source": [
              "id"
            ]
          }
        }
      }
    }
  }
}