PUT attach_local
{
  "mappings" : {
    "doc" : {
      "properties" : {
        "attachment" : {
          "properties" : {
            "content" : {
              "type" : "text"
            },
            "content_length" : {
              "type" : "long"
            },
            "content_type" : {
              "type" : "text"
            },
            "language" : {
              "type" : "text"
            }
          }
        },
        "resume" : {
          "type" : "text"
        }
      }
    }
  }
}