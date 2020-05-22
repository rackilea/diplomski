val text = "May  5 23:00:01 10.14.3.10 %ASA-6-302015: Built inbound UDP connection"
val regex = """^.*?(?=\s\d{1,3}.\d{1,3}.\d{1,3}.\d{1,3}\s%)|(?<=[\w:]\s)\w+(?=\s[cr])""".r
val result = regex.findAllIn(text)
result.foreach { x => println(x) }
// => May  5 23:00:01
//    UDP