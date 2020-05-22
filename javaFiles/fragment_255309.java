GET my_index/_search
{
  "query": {
    "nested": {
      "path": "tokens",
      "query": {
        "bool": {
          "must": [
            { "match": { "tokens.form": "house" }},
            { "match": { "tokens.tags":  "NN" }} 
          ]
        }
      }
    }
  }
}