object TestCSV extends App {
    val bufferedSource = io.Source.fromFile("/Users/toni/learn/scala/test-stackoverflow/src/main/scala/com/cuaqea/csv/file.csv")
    val cache = collection.mutable.Map[Tuple2[String,String], Tuple2[String,String]]()
  for (line <- bufferedSource.getLines) {
        val cols = line.split("\\s+").map(_.trim)

      println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")
      cache += (new Tuple2(cols(0),cols(1)) -> new Tuple2(cols(2), cols(3)))

  }
  println(cache.toString)
    bufferedSource.close
}