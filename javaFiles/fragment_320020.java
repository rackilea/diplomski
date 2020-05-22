{
  "size": 1000,
  "min_score": 1,
  "query": {
    "bool": {
      "must": [
        {
          "query_string": {
            "query": "MY_DATA_TYPE",
            "fields": [
              "doc.db_doc_type"
            ]
          }
        },
        {
          "query_string": {
            "query": "MY_SPECIFIC_TYPE",
            "fields": [
              "doc.db_doc_specific"
            ]
          }
        }
      ],
      "should": {
        "match": {
          "doc.such": {
            "query": "F-G/4"
          }
        }
      }
    }
  }
}