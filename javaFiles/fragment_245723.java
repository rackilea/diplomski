curl -XGET 'http://127.0.0.1:9200/test/test/_search?pretty=1'  -d '{
  "query" : {
     "match" : {
        "userName.autocomplete" : "brian"
     }
  }
}
'

# {
#    "hits" : {
#       "hits" : [
#          {
#             "_source" : {
#                "userName" : "briangriffen"
#             },
#             "_score" : 0.1486337,
#             "_index" : "test",
#             "_id" : "AWzezvEFRIykOAr75QbtcQ",
#             "_type" : "test"
#          },
#          {
#             "_source" : {
#                "userName" : "briangumble"
#             },
#             "_score" : 0.1486337,
#             "_index" : "test",
#             "_id" : "qIABuMOiTyuxLOiFOzcURg",
#             "_type" : "test"
#          },
#          {
#             "_source" : {
#                "userName" : "brianlilley"
#             },
#             "_score" : 0.076713204,
#             "_index" : "test",
#             "_id" : "fGgTITKvR6GJXI_cqA4Vzg",
#             "_type" : "test"
#          }
#       ],
#       "max_score" : 0.1486337,
#       "total" : 3
#    },
#    "timed_out" : false,
#    "_shards" : {
#       "failed" : 0,
#       "successful" : 5,
#       "total" : 5
#    },
#    "took" : 8
# }