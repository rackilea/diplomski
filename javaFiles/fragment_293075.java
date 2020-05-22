GET my_index/_search
{
  "query": {
    "range": {
      "text.digit": {
        "gte": 3.2,
        "lte": 3.5
      }
    }
  }
}