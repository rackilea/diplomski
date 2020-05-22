PUT stackoverflow
{
  "settings": {
    "analysis": {
      "analyzer": {
        "customanalyzer": {
          "type": "custom",
          "tokenizer": "standard",
          "filter": [
            "lowercase",
            "standard",
            "generatewordparts"
          ]
        }
      },
      "filter": {
        "generatewordparts": {
          "type": "word_delimiter",
          "split_on_numerics": false,
          "split_on_case_change": false,
          "generate_word_parts": true,
          "generate_number_parts": false,
          "stem_english_possessive": false,
          "catenate_all": false
        }
      }
    }
  },
  "mappings": {
    "emptags": {
      "properties": {
        "employeeid": {
          "type": "integer"
        },
        "tagName": {
          "type": "text",
          "fielddata": true,
          "analyzer": "customanalyzer",
          "search_analyzer": "customanalyzer"
        }
      }
    }
  }
}

GET stackoverflow/emptags/1
{
  "employeeid": 1,
  "tagName": "social_security_number"
}

GET stackoverflow/_analyze
{
  "analyzer" : "customanalyzer",
  "text" : "social_security_number123"
}

GET stackoverflow/_search
{
  "query": {
    "query_string": {
      "default_field": "tagName",
      "query": "*curi*"
    }
  }
}