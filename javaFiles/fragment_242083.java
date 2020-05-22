DELETE /test_index

PUT /test_index
{
   "settings": {
      "number_of_shards": 1
   },
   "mappings": {
      "doc": {
         "properties": {
            "name": {
               "type": "string",
               "index": "not_analyzed"
            },
            "pets": {
               "type": "nested",
               "properties": {
                  "name": {
                     "type": "string",
                     "index": "not_analyzed"
                  },
                  "type": {
                     "type": "string",
                     "index": "not_analyzed"
                  }
               }
            }
         }
      }
   }
}

PUT /test_index/doc/1
{
    "name": "Sloan",
    "pets": [
        { "name": "Pearl", "type": "cat" },
        { "name": "Dexter", "type": "cat" }
    ]
}

POST /test_index/_search
...
{
   "took": 2,
   "timed_out": false,
   "_shards": {
      "total": 1,
      "successful": 1,
      "failed": 0
   },
   "hits": {
      "total": 1,
      "max_score": 1,
      "hits": [
         {
            "_index": "test_index",
            "_type": "doc",
            "_id": "1",
            "_score": 1,
            "_source": {
               "name": "Sloan",
               "pets": [
                  {
                     "name": "Pearl",
                     "type": "cat"
                  },
                  {
                     "name": "Dexter",
                     "type": "cat"
                  }
               ]
            }
         }
      ]
   }
}

PUT /test_index/doc/1
{
    "name": "Sloan",
    "pets": [
        { "name": "Pearl", "type": "cat" },
        { "name": "Dexter", "type": "cat" },
        { "name": "Momo", "type": "cat" }
    ]
}

POST /test_index/_search
...
{
   "took": 8,
   "timed_out": false,
   "_shards": {
      "total": 1,
      "successful": 1,
      "failed": 0
   },
   "hits": {
      "total": 1,
      "max_score": 1,
      "hits": [
         {
            "_index": "test_index",
            "_type": "doc",
            "_id": "1",
            "_score": 1,
            "_source": {
               "name": "Sloan",
               "pets": [
                  {
                     "name": "Pearl",
                     "type": "cat"
                  },
                  {
                     "name": "Dexter",
                     "type": "cat"
                  },
                  {
                     "name": "Momo",
                     "type": "cat"
                  }
               ]
            }
         }
      ]
   }
}