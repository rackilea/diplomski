PUT products
{
"settings": {
"analysis": {
  "analyzer": {
    "custom_analyzer": {
      "type": "custom",
      "tokenizer": "my_pattern_tokenizer",
      "char_filter": [
        "html_strip"
      ],
      "filter": [
        "lowercase",
        "asciifolding"
      ]
    }
   },
   "tokenizer": {
     "my_pattern_tokenizer": {
          "type": "pattern",
          "pattern": "-|\\d"
        }
   }
  }
},
"mappings": {
"doc": {
  "properties": {
    "code": {
      "type": "text",
       "analyzer": "custom_analyzer"
      }
    }
  }
 }
}