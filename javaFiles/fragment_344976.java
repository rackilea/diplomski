import akka.actor.{ActorSystem, Props, Actor, ActorRef, ActorLogging}
import collection.mutable.ListBuffer

sealed trait Messaging
case class Add(msgs: List[String]) extends Messaging
case class Receive(msgs: String) extends Messaging
case class SendAll(dest: ActorRef) extends Messaging 


class Messenger extends Actor with ActorLogging {
  var messages = new ListBuffer[String]()

  def receive = {
    case Add(msgs)     => messages ++= msgs
    case Receive(msg)  => log.info(s"received $msg from ${sender.path}.")
    case SendAll(dest) => messages.foreach(dest ! Receive(_))
  }
}

object Main extends App {

  val system = ActorSystem("MessengerSystem")
  val aActor = system.actorOf(Props[Messenger], name = "aActor")
  val bActor = system.actorOf(Props[Messenger], name = "bActor")

  aActor ! Add(List("A1","A2","A3"))
  bActor ! Add(List("B1","B2","B3","B4"))

  aActor ! SendAll(bActor)
  bActor ! SendAll(aActor)

  system.shutdown
}