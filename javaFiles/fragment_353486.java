{
   "took": 2,
   "timed_out": false,
   "_shards": {
      "total": 2,
      "successful": 2,
      "failed": 0
   },
   "hits": {
      "total": 2,
      "max_score": 0.94125634,
      "hits": [
         {
            "_index": "test_index",
            "_type": "person",
            "_id": "5",
            "_score": 0.94125634,
            "_source": {
               "first_name": "Taylor",
               "last_name": "Johnson",
               "building_id": 2
            }
         },
         {
            "_index": "test_index",
            "_type": "person",
            "_id": "4",
            "_score": 0.5906161,
            "_source": {
               "first_name": "John",
               "last_name": "Taylor",
               "building_id": 2
            }
         }
      ]
   }
}