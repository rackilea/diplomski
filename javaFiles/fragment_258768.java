{
  "settings": {
    "index": {
      "analysis": {
        "filter": {
          "lowercaseFilter": {
            "type": "lowercase"
          }
        },
        "analyzer": {
          "email": {
            "filter": [
              "lowercaseFilter"
            ],
            "type": "custom",
            "tokenizer": "uax_url_email"
          }
        }
      }
    }
  },
  "mappings": {
    "properties": {
      "emailId":
      {
        "analyzer": "email",
        "type": "text"
      }
    }
  }
}