{
  "scriptFile" : "..\\fabrikam-functions-1.0-SNAPSHOT.jar",
  "entryPoint" : "com.fabrikam.functions.Function.functionHandler",
  "bindings" : [ {
    "type" : "timerTrigger",
    "name" : "timerInfo",
    "direction" : "in",
    "schedule" : "*/30 * * * * *"
  }, {
    "type" : "documentdb",
    "name" : "$return",
    "direction" : "out",
    "databaseName" : "db",
    "collectionName" : "coll",
    "connection" : "CosmosDBConnectionString",
    "createIfNotExists" : true
  } ],
  "disabled" : false
}