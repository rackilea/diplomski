{
  "protocol" : "sample",
  "namespace" : "com.sample",
  "types" : [ {
    "type" : "record",
    "name" : "Category",
    "fields" : [ {
      "name" : "price_score",
      "type" : [ "null", "string" ],
      "default" : null
    }, {
      "name" : "confidence_score",
      "type" : [ "null", "string" ],
      "default" : null
    } ]
  }, {
    "type" : "record",
    "name" : "vObject",
    "fields" : [ {
      "name" : "site_id",
      "type" : "int",
      "default" : 0
    }, {
      "name" : "categories",
      "type" : [ "null", {
        "type" : "map",
        "values" : "Category"
      } ],
      "default" : null
    }, {
      "name" : "price_score",
      "type" : [ "null", "float" ],
      "default" : null
    }, {
      "name" : "confidence_score",
      "type" : [ "null", "float" ],
      "default" : null
    } ]
  }, {
    "type" : "record",
    "name" : "SampleObject",
    "fields" : [ {
      "name" : "lv",
      "type" : [ "null", {
        "type" : "array",
        "items" : "vObject"
      } ],
      "default" : null
    }, {
      "name" : "lmd",
      "type" : "long",
      "default" : -1
    } ]
  } ],
  "messages" : {
  }
}