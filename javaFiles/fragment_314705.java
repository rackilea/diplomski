{
  "mappings": {
    "your_type": {
      "dynamic_templates": [
        {
          "strings": {
            "match_mapping_type": "string",
            "path_match": "parameters.*",
            "mapping": {
              "type": "string",
              "index": "not_analyzed"
            }
          }
        }
      ]
    }
  }
}