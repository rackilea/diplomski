PUT test
{
  "settings": {
    "analysis": {
      "analyzer": {
        "category_synonym": {
          "tokenizer": "whitespace",
          "filter": [
            "synonym_filter",
            "my_edgeNGram_filter"
          ]
        },
        "standard_edgeNGram": {
          "tokenizer": "standard",
          "filter": [
            "lowercase",
            "synonym_filter",
            "my_edgeNGram_filter"
          ]
        }
      },
      "filter": {
        "synonym_filter": {
          "type": "synonym",
          "synonyms_path": "synonyms.txt"
        },
        "my_edgeNGram_filter": {
          "type": "edgeNGram",
          "min_gram": 2,
          "max_gram": 8
        }
      }
    }
  },
  "mappings": {
    "test": {
      "properties": {
        "name": {
          "type": "string",
          "analyzer": "category_synonym",
          "index_analyzer": "standard_edgeNGram",
          "fields": {
            "raw": {
              "type": "string",
              "index": "not_analyzed"
            }
          }
        }
      }
    }
  }
}

POST test/test/1
{"name": "Pitch video"}
POST test/test/2
{"name": "Video"}

GET /test/test/_search
{
  "query": {
    "query_string": {
      "query": "name:fil"
    }
  }
}