val text = "May  5 23:00:01 10.14.3.10 %ASA-6-302015: Built inbound UDP connection"
val regex = """^(.*?)\s+\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\s%.*[\w:]\s+(\w+)\s+[cr].*""".r
val results = text match {
  case regex(date, protocol) => Array(date, protocol)
  case _ => Array[String]()
}
// Demo printing
results.foreach { m =>
  println(m)
}