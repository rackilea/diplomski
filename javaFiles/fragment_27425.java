{
  "query": {
    "function_score": {
      "functions": [
        {
          "field_value_factor": {
            "field": "thread_view",
            "factor": 1.2,
            "modifier": "sqrt"
          }
        }
      ],
      "query": {
        "bool": {
          "should": [
            {
              "match": {
                "thread_name": " + keyword + "
              }
            },
            {
              "nested": {
                "path": "messages",
                "query": {
                  "bool": {
                    "should": [
                      {
                        "match": {
                          "messages.message_text": " + keyword + "
                        }
                      }
                    ]
                  }
                },
                "inner_hits": {}
              }
            }
          ]
        }
      },
      "score_mode": "multiply"
    }
  }
}