PUT my_index
{
  "settings": {
    "analysis": {
      "analyzer": {
        "my_analyzer": {
          "type": "custom",
          "tokenizer": "my_tokenizer"
        }
      },
      "tokenizer": {
        "my_tokenizer": {
          "type": "char_group",
          "tokenize_on_chars": [
            "letter",
            "whitespace"
          ]
        }
      }
    }
  },
  "mappings": {
    "properties": {
      "text": {
        "type": "text",
        "fields": {
          "digit": {
            "type": "text",
            "analyzer": "my_analyzer"
          }
        }
      }
    }
  }
}