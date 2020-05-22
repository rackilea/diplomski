import java.util.concurrent.Executors

import scala.concurrent.{ExecutionContext, Future}

object TestFutures extends App {

  val computeContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(10))
  val readyContext = ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(10))

  val futures = for (i <- 1 to 10) yield {
    val f = Future { Thread.sleep(1000 * (10 - i)); i } (computeContext)
    f.onSuccess { case j => println(s"$j is ready!") } (readyContext)
    f
  }

  implicit val sequenceContext = ExecutionContext.fromExecutorService(Executors.newSingleThreadExecutor())

  Future.sequence(futures).foreach(println)

}