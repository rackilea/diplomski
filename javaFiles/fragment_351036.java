PUT events
{
  "mappings": {
    "event": {
      "properties": {
        "id": {
          "type": "long"
        },
        "type": {
          "type": "string",
          "index": "not_analyzed"
        },
        "event_date": {
          "type": "date"
        },
        "city": {
          "type": "string",
          "fields": {
            "raw": {
              "type": "string",
              "index": "not_analyzed"
            }
          }
        },
        "name": {
          "type": "string"
        }
      }
    }
  }
}