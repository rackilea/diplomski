GET student/_search
{
  "size": 0, 
    "aggs" : {
        "name_id" : {
            "terms" : {
                "script" : {
                    "source": "doc['name.keyword'].value + '_' + doc['id'].value",
                    "lang": "painless"
                }
            }
        }
    }
}