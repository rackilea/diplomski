{
  "config": {
    log : "debug"
  },
  "extractor" : {
    "jdbc": { "driver": "com.microsoft.sqlserver.jdbc.SQLServerDriver",
              "url": "jdbc:sqlserver://10.10.10.10;databaseName=My_DB;",
              "userName": "sa",
              "userPassword": "123",
              "query": "select * from My_Table" 
            }
  },

  "transformers" : [
    { "vertex": { "class": "Company"} }
  ],
   "loader" : {
    "orientdb": {
      "dbURL": "plocal:D:\DB\Orient_DB",
      dbUser: "admin",
      dbPassword: "admin",
      "dbAutoCreate": true,
      "tx": false,
      "batchCommit": 1000,
      "wal" : false,
      "dbType": "graph"
    }
  }
}