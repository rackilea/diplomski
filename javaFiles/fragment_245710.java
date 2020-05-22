{
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
}