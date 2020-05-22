POST stopdata/_search
{
  "query": {
    "function_score": {
      "query": {
        "filtered": {
          "query": {
            "match": {
              "question": "Hello Dr. Iam suffering from fever with cough nd cold since 3 days"
            }
          },
          "filter": {
            "bool": {
              "must": [
                {
                  "terms": {
                    "topics": [
                      "fever",
                      "cough"
                    ]
                  }
                }
              ],
              "must_not": [
                {
                  "terms": {
                    "topics": [
                      "children",
                      "child",
                      "childrens health"
                    ]
                  }
                }
              ]
            }
          }
        }
      },
      "random_score": {}
    }
  },
  "highlight": {
    "fields": {
      "keyword": {}
    }
  }
}