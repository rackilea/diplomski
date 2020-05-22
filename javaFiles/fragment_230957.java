import scala.concurrent.{Await,Future}
...

 try {
      val counterValue  = Await.result(counterFuture, 5.seconds)
      map.put("counter", counterValue)       
    } catch {
      case t: TimeoutException => ...
      case t: Exception => ...
   }