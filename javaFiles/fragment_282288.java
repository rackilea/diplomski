PUT _template/documents
{
  "template": "documents*",
   "settings" : {
      "analysis" : {
         "analyzer" : {
            "filename_search" : {
               "tokenizer" : "filename",
               "filter" : ["lowercase"]
            },
            "filename_index" : {
               "tokenizer" : "filename",
               "filter" : ["lowercase","edge_ngram"]
            }
         },
         "tokenizer" : {
            "filename" : {
               "pattern" : "[^\\p{L}\\d]+",
               "type" : "pattern"
            }
         },
         "filter" : {
            "edge_ngram" : {
               "side" : "front",
               "max_gram" : 20,
               "min_gram" : 1,
               "type" : "edgeNGram"
            }
         }
      }
   },
   "mappings" : {
      "doc" : {
         "properties" : {
            "filename" : {
               "type" : "text",
               "search_analyzer" : "filename_search",
               "index_analyzer" : "filename_index"
            }
         }
      }
   }
}