POST /test/_doc/_search
{
  "query": {
    "query_string": {
      "query": "*tg*"
    }
  }
}