val format = new java.text.SimpleDateFormat("HH:mm:ss").format(_: Date)

val startTime = new Date
(1 to 8) map {_ => future{ Thread.sleep(10000) }}
future{
  2+2
  println(s"2+2 done. Start time: ${format(startTime)}, end time: ${format(new Date)}")
}

// 2+2 done. Start time: 20:48:18, end time: 20:48:28