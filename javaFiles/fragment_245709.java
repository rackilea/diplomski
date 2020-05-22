{
  "my_index": {
    "aliases": {},
    "mappings": {},
    "settings": {
      "index": {
        "number_of_replicas": "1",
        "number_of_shards": "5"
      },
      "analysis": {
        "analyzer": {
          "second": {
            "type": "custom",
            "filter": [
              "lowercase",
              "synonym"
            ],
            "tokenizer": "standard"
          }
        },
        "filter": {
          "synonym": {
            "type": "synonym",
            "synonyms": [
              "i pad => ipad",
              "smart phone => smartphone"
            ]
          }
        }
      }
    },
    "warmers": {}
  }
}