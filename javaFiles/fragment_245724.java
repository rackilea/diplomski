curl -XGET 'http://127.0.0.1:9200/test/test/_search?pretty=1'  -d '
{
  "query" : {
     "match" : {
        "userName.autocomplete" : "brianlilley"
     }
  }
}
'

# {
#    "hits" : {
#       "hits" : [
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
#       "max_score" : 0.076713204,
#       "total" : 1
#    },
#    "timed_out" : false,
#    "_shards" : {
#       "failed" : 0,
#       "successful" : 5,
#       "total" : 5
#    },
#    "took" : 4
# }