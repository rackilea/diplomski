{
   "query": {
      "bool": {
         "minimum_should_match": 1,
         "should": [
            {
               "term": {
                  "firstname": "Marie"
               }
            },
            {
               "term": {
                  "address": "North America"
               }
            }
         ]
      }
   }
}