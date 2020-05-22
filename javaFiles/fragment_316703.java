{
  "prop" : "Hello",
  "child1" : {
    "anInt" : -1
  },
  "map" : {
    "JustString" : "JustValue",
    "List_With_All_MyMaps" : {
      "@type" : "MyMap[]",
      "@values" : [ {
        "Key" : "Value",
        "object" : {
          "@type" : "Child1",
          "anInt" : 2
        }
      }, {
        "Key" : "Value"
      } ]
    },
    "List_With_All_Child1" : {
      "@type" : "Child1[]",
      "@values" : [ {
        "anInt" : 41
      }, {
        "anInt" : 42
      } ]
    }
  }
}