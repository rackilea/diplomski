GET my_index/_search
{
  "size": 1, 
  "query": {
    "match_all": {}
  },
  "sort" : {
        "_script" : {
            "type" : "number",
            "script" : {
                "lang": "painless",
                "source": "Integer.parseInt(doc['_id'].value)"

            },
            "order" : "desc"
        }
    }
}