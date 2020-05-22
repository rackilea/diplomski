GET testindex4/_search
{
  "size":0,
  "aggs": {
    "byHours": {    ---> if you need doc count in distinct hours
      "terms": {
        "script": {
          "source": "doc[params.date_field].value.hourOfDay;",
          "params": {
            "date_field": "date"
          }
        }
      }
    },
    "distinct_hours": {      ---> count of distinct hours
      "cardinality": {
        "script": {
          "lang": "painless",
          "source": "doc[params.date_field].value.hourOfDay;",
          "params": {
            "date_field": "date"
          }
        }
      }
    }
  }
}