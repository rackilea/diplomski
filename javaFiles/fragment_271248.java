"bool" : {
  "must" : [
    {
      "term" : {
        "exgroups" : {
          "value" : "TSX",
          "boost" : 1.0
        }
      }
    }
  ],
  "filter" : [
    {
      "script" : {
        "script" : {
          "source" : "doc['exgroups'].values.length == 1",
          "lang" : "painless"
        },
        "boost" : 1.0
      }
    }
  ],
  "adjust_pure_negative" : true,
  "boost" : 1.0
}