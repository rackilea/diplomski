{
  "from": 0,
  "size": 100,
  "query": {
    "simple_query_string": {
      "query": "{\n  \"bool\" : {\n    \"should\" : [\n      {\n        \"terms\" : {\n          \"myfield1.keyword\" : [\n            \"foo\"\n          ],\n          \"boost\" : 1.0\n        }\n      },\n      {\n        \"terms\" : {\n          \"myfield2.keyword\" : [\n            \"search\"\n          ],\n          \"boost\" : 1.0\n        }\n      }\n    ],\n    \"adjust_pure_negative\" : true,\n    \"minimum_should_match\" : \"100%\",\n    \"boost\" : 1.0\n  }\n}",
      "flags": -1,
      "default_operator": "or",
      "analyze_wildcard": false,
      "auto_generate_synonyms_phrase_query": true,
      "fuzzy_prefix_length": 0,
      "fuzzy_max_expansions": 50,
      "fuzzy_transpositions": true,
      "boost": 1
    }
  }
}