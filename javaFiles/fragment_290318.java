import scala.concurrent._
  import duration._
  import scala.concurrent.ExecutionContext.Implicits.global //some execution context

  class Queue[T](solvers: Seq[() => T]) extends Iterator[T]{
     case class Result(f: Future[Result], r: T)
     var futures: Set[Future[Result]] = solvers map {s => 
        lazy val f: Future[Result]  = Future{Result(f, s())}
        f
     } toSet

     def hasNext() = futures.nonEmpty        

     def next() = {         
        val result = Await.result((Future firstCompletedOf futures.toSeq), Duration.Inf)
        futures -= result.f
        result.r
     }
  }

scala> val q = new Queue(List(() => 1, () => 2, () => 3, () => 4))
q: Queue[Int] = non-empty iterator

scala> q.next
res14: Int = 2

scala> q.next
res15: Int = 1

scala> q.foreach(println)
4
3