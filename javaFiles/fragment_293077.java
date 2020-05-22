GET my_index/_search
{
  "query": {
    "range": {
      "text.digit": {
        "gt": 3.5
      }
    }
  }
}