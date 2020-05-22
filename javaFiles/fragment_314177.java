import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.language.postfixOps

import akka.actor.{ActorRef, ActorSystem, Props, Stash}
import akka.pattern.ask
import akka.util.Timeout

case object HasNext
case object GetNext

case class Result(value: Any)
case object Done

class ResultCollector extends Actor with Stash {

  val queue = scala.collection.mutable.Queue.empty[Result]

  def collecting: Actor.Receive = {
    case HasNext       => if (queue.isEmpty) stash else sender ! true
    case GetNext       => if (queue.isEmpty) stash else sender ! queue.dequeue
    case value: Result => unstashAll; queue += value
    case Done          => unstashAll; context become serving
  }

  def serving: Actor.Receive = {
    case HasNext => sender ! queue.nonEmpty
    case GetNext => sender ! { if (queue.nonEmpty) queue.dequeue else new NoSuchElementException }
  }

  def receive = collecting
}

class ResultStreamIteration(resultCollector: ActorRef) extends Iterator {

  implicit val timeout: Timeout = Timeout(30 seconds)

  override def hasNext(): Boolean = Await.result(resultCollector ? HasNext, Duration.Inf) match {
    case b: Boolean => b
  }

  override def next(): Any = Await.result(resultCollector ? GetNext, Duration.Inf) match {
    case Result(value: Any) => value
    case e: Throwable       => throw e
  }
}

object Test extends App {
  implicit val exec = scala.concurrent.ExecutionContext.global
  val system = ActorSystem.create("Test")
  val actorRef = system.actorOf(Props[ResultCollector])
  Future {
    for (i <- 1 to 10000) actorRef ! Result(s"Result $i"); actorRef ! Done
  }
  val iterator = new ResultStreamIteration(actorRef)
  while (iterator.hasNext()) println(iterator.next)
  system.shutdown()
}