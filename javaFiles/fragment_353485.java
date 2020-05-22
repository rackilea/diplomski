curl -XPOST "http://localhost:9200/test_index/person/_search" -d'
{
   "query": {
      "filtered": {
         "query": {
            "multi_match": {
               "query": "taylor",
               "fields": [
                  "first_name",
                  "last_name"
               ]
            }
         },
         "filter": {
            "term": {
               "building_id": 2
            }
         }
      }
   }
}'