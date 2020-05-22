{
  "nested": {
    "query": {
      "match": {
        "links.ip_address": {          <--------------------- change here
          "query": "10.214.159.193",
          "operator": "OR",
          "prefix_length": 0,
          "max_expansions": 50,
          "fuzzy_transpositions": true,
          "lenient": false,
          "zero_terms_query": "NONE",
          "auto_generate_synonyms_phrase_query": true,
          "boost": 1
        }
      }
    },
    "path": "links",
    "ignore_unmapped": false,
    "score_mode": "none",
    "boost": 1
  }
}