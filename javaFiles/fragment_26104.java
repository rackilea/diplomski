/POST http://localhost:9200/test/users/_search
{
  "query": {
    "match": {
      "IPRANGE": "tr"
    }
  }
}