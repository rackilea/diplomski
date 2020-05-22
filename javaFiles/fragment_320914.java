String mapping = {
  "typename": {
    "properties": {
      "GroupName": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword"
          }
        }
      },
      "Createdby": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword"
          }
        }
      },
      "GroupUser": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword"
          }
        }
      },
      "UpdatedDateTime": {
        "type": "date",
        "format": "yyyyMMddHHmmssSSSZ"
      },
      "CreatedDateTime": {
        "type": "date",
        "format": "yyyyMMddHHmmssSSSZ"
      },
      "GroupId": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword"
          }
        }
      },
      "status": {
        "type": "text",
        "fields": {
          "keyword": {
            "type": "keyword"
          }
        }
      }
    }
  }
}