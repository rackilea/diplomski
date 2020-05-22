GET testindex4/_search
{
  "size": 0,
  "aggs": {
    "byDevice": {
      "terms": {
        "field": "device.model"
      },
      "aggs": {
        "byDate": {
          "terms": {
            "script": {
              "source": "doc[params.date_field].value.toString('yyyy-MM-dd')",
              "params": {
                "date_field": "date"
              }
            }
          },
          "aggs": {
            "byHours": {
              "terms": {
                "script": {
                  "source": "doc[params.date_field].value.getHour();",
                  "params": {
                    "date_field": "date"
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}