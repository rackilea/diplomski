http+tcp://127.0.0.1:8529@_system> db._create("testIndex")
http+tcp://127.0.0.1:8529@_system> db.testIndex.ensureIndex({type: "fulltext", fields: ["complete:3da549f0-0e88-4297-b6af-5179b74bd929"]})
{ 
  "fields" : [ 
    "complete:3da549f0-0e88-4297-b6af-5179b74bd929" 
  ], 
  "id" : "testIndex/4687162", 
  "minLength" : 2, 
  "sparse" : true, 
  "type" : "fulltext", 
  "unique" : false, 
  "isNewlyCreated" : true, 
  "code" : 201 
}

http+tcp://127.0.0.1:8529@_system> db.testIndex.save({'complete:3da549f0-0e88-4297-b6af-5179b74bd929': "find me"})
{ 
  "_id" : "testIndex/4687201", 
  "_key" : "4687201", 
  "_rev" : "4687201" 
}

http+tcp://127.0.0.1:8529@_system> db._query('FOR doc IN FULLTEXT(testIndex, "complete:3da549f0-0e88-4297-b6af-5179b74bd929", "find") RETURN doc')
[object ArangoQueryCursor, count: 1, hasMore: false]


[ 
  { 
    "_id" : "testIndex/4687201", 
    "_key" : "4687201", 
    "_rev" : "4687201", 
    "complete:3da549f0-0e88-4297-b6af-5179b74bd929" : "find me" 
  } 
]