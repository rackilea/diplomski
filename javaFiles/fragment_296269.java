"aggs": {
    "group_by_interval": {
      "date_histogram": {
        "field": "spentOn",
        "interval": "month",
        "min_doc_count": 0,
        "extended_bounds": {
          "min": "1451606400000",
          "max": "1483142400000"
        }
      },
      "aggs": {
        "group_per_project": {
          "histogram": {
            "field": "taskId",
            "interval": 1
          },
          "aggs": {
            "per_user": {
              "terms": {
                "field": "userId"
              },
              "aggs": {
                "hours": {
                  "sum": {
                    "field": "hours"
                  }
                }
              }
            }
          }
        }
      }
    }
  }