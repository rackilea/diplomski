PUT your_index
{
  "settings": {
    "analysis": {
      "analyzer": {
        "prefix_analyzer": {
          "tokenizer": "prefix_tokenizer",
          "filter": [
            "lowercase"
          ]
        },
        "search_prefix_analyzer": {
          "tokenizer": "keyword",
          "filter": [
            "lowercase"
          ]
        }
      },
      "tokenizer": {
        "prefix_tokenizer": {
          "type": "edgeNGram",
          "min_gram": "1",
          "max_gram": "25"
        }
      }
    }
  },
  "mappings": {
    "your_type": {
      "properties": {
        "doc": {
          "properties": {
            "such": {
              "type": "string",
              "fields": {
                "starts_with": {
                  "type": "string",
                  "analyzer": "prefix_analyzer",
                  "search_analyzer": "search_prefix_analyzer"
                }
              }
            }
          }
        }
      }
    }
  }
}