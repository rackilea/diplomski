GET your_index/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "script": {
            "script": "doc['tags'].values.length == 2"
          }
        },
        {
          "term": {
            "tags": {
              "value": "a"
            }
          }
        },
        {
          "term": {
            "tags": {
              "value": "b"
            }
          }
        }
      ]
    }
  }
}