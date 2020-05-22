object BlockingExecution {
  val executor = ExecutionContext.fromExecutor(new ForkJoinPool(20))
}

def blockingFuture[T](f: => T) = {
  future( f )(BlockingExecution.executor)
}

val startTime = new Date
(1 to 8) map {_ => blockingFuture{ Thread.sleep(10000) }}
future{
  2+2
  println(s"2+2 done. Start time: ${format(startTime)}, end time: ${format(new Date)}")
}

// 2+2 done. Start time: 21:26:18, end time: 21:26:18