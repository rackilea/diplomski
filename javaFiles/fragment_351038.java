POST events/event/_search
{
  "size": 0,
  "query": {
    "term": {
      "type": "CRASH"
    }
  },
  "aggs": {
    "cities": {
      "terms": {
        "field": "city.raw",
        "size": 6,
        "order": {
          "latest": "desc"
        }
      },
      "aggs": {
        "latest": {
          "max": {
            "field": "event_date"
          }
        },
        "last_3_events": {
          "top_hits": {
            "size": 3,
            "sort": {
              "event_date": "desc"
            }
          }
        }
      }
    }
  }
}