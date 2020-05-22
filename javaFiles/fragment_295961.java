{
  "bool": {
    "must": [
      {
        ...query_restricting_set_of_docs
      },
      {
        "bool": {
          "should": [
            {
              ...query_restricting_set_of_docs
            },
            {
              ...other_query
            }
          ]
        }
      }
    ]
  }
}