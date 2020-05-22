{
"bool": {
  "must": [
    {
      "term": {
        "financialAdviserId": {
          "value": "123"
        }
      }
    },
    {
      "bool": {
        "should": [
          {
            "term": {
              "investorDateOfBirth": {
                "value": "1987-11-12"
              }
            }
          },
          {
            "term": {
              "financialAdviserId": {
                "value": "123"
              }
            }
          }
        ]
      }
    }
  ]
}