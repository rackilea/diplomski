val conf = NutchConfiguration.create()
val fs = FileSystem.get(conf)
val file = new Path(".../part-00000/data")
val reader = new SequenceFile.Reader(fs, file, conf)

val webdata = Stream.continually {
  val key = new Text()
  val content = new Content()
  reader.next(key, content)
  (key, content)
}

println(webdata.head)