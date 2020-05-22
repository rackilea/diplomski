{
  "size": 0,
  "aggregations": {
    "timeslice": {
      "histogram": {
        "script": {
          "inline": "doc['openDate'].date.setZone(DateTimeZone.forID(tz)); doc['openDate'].date.getHourOfDay()",
          "params": {
            "tz": "Europe/London"
          }
        },
        "interval": 1,
        "min_doc_count": 0,
        "extended_bounds": {
          "min": 0,
          "max": 23
        },
        "order": {
          "_key": "desc"
        },
        "offset": 0
      }
    }
  }
}