POST /*/_update_by_query

{
    "script" : {
        "inline": "ctx._source.age_when_bought = (new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:sszzz\").parse(ctx._source.purchase_date).getTime()
- new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:sszzz\").parse(ctx._source.birth_date).getTime())"
    },
    "query": {
        "bool": {
          "must": [
            {
              "match": {
                "breed": "Persian"
              }
            }
          ]
        }
    }
}