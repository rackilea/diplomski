{
  "took": 2,
  "timed_out": false,
  "_shards": {
    "total": 5,
    "successful": 5,
    "failed": 0
  },
  "hits": {
    "total": 19,
    "max_score": 1.1,
    "hits": Array[10][
      {
        "_index": "first_index_name",
        "_type": "first_type_of_first_index",
        "_id": "doc-id-125125422",
        "_score": 1.1,
        "_source": { /*here is your indexed document*/ }
      },
      {
        "_index": "second_index_name",
        "_type": "first_type_of_second_index",
        "_id": "doc-id-212452314",
        "_score": 0.9,
        "_source": {...}
      },
      ...
    ]
  }
}