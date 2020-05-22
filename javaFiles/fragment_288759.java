{
"query": {
"bool": {
  "must": [
    {
      "match": {
        "code": {
          "query": "TE-7000-8002-W",
          "operator": "and"
        }
      }
    },
    {
      "match": {
        "locale": {
          "query": "en_US",
          "operator": "and"
          }
        }
      }
     ]
    }
  }
}