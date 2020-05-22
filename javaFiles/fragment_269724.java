...

 "definitions" : {
    "SampleDTO" : {
      "type" : "object",
      "required" : [ "integer", "string" ],
      "properties" : {
        "integer" : {
          "type" : "integer",
          "format" : "int32",
          "minimum" : 5,
          "maximum" : 10
        },
        "string" : {
          "type" : "string"
        },

...