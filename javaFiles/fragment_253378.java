PUT /test
{
  "settings": {
    "number_of_shards": "1",
    "number_of_replicas": "0",
    "analysis": {
      "analyzer": {
        "custom_lowercase": {
          "filter": [
            "lowercase"
          ],
          "type": "custom",
          "tokenizer": "keyword"
        }
      }
    }
  },
  "mappings": {
    "_doc": {
      "properties": {
        "hash": {
          "type": "text",
          "analyzer": "custom_lowercase",
          "fields": {
            "keyword": {
              "type": "keyword"
            }
          }
        }
      }
    }
  }
}