curl -XPUT 'http://127.0.0.1:9200/test/?pretty=1'  -d '
{
  "mappings" : {
     "test" : {
        "properties" : {
           "userName" : {
              "fields" : {
                 "autocomplete" : {
                    "search_analyzer" : "username_search",
                    "index_analyzer" : "username_index",
                    "type" : "string"
                 },
                 "userName" : {
                    "index" : "not_analyzed",
                    "type" : "string"
                 }
              },
              "type" : "multi_field"
           }
        }
     }
  },
  "settings" : {
     "analysis" : {
        "filter" : {
           "username_ngram" : {
              "max_gram" : 15,
              "min_gram" : 1,
              "type" : "edge_ngram"
           }
        },
        "analyzer" : {
           "username_index" : {
              "filter" : [
                 "lowercase",
                 "username_ngram"
              ],
              "tokenizer" : "keyword"
           },
           "username_search" : {
              "filter" : [
                 "lowercase"
              ],
              "tokenizer" : "keyword"
           }
        }
     }
  }
}
'