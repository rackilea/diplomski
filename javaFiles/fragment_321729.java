{
  "query": {
    "bool": {
      "minimum_should_match": 1,
      "should": [
        {
          "bool": {
            "must": [
              {
                "term": {
                  "firstname": "Marie"
                }
              },
              {
                "term": {
                  "lastname": "Doe"
                }
              }
            ]
          }
        },
        {
          "term": {
            "address": "North America"
          }
        }
      ]
    }
  }
}