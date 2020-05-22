{ 
    "aggregate" : "rssSearch" 
  , "pipeline" : [ 
     { "$match" : { "_id" : "123"}} 
   , { "$project" : { "journeys" : "$rssSearchResponse.journeys"}}
   , { "$unwind" : "$journeys"}
   , { "$match" : { "journeys.stops" : 0}}
  ]
}