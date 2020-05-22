lazy val sc = ... // create Spak Context
lazy val hc = new HiveContext(sc)
val results = hc.sql("SELECT record_name as name FROM test_table WHERE day < current_date")
results.take(10)
  .map(r => s"name: ${r.getAs("name")}")
  .foreach(println)