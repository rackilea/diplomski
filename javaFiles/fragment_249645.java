GET documents_test2/_search
{
   "size" : 45,
   "query": {
     "query_string" : {
        "default_field" : "*",
        "query" : "40011"
    }
}