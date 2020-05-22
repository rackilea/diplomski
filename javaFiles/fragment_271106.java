import java.util.concurrent.atomic.AtomicInteger

import akka.actor._
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory._
import org.specs2.mutable.Specification

class BoundedActorSpec extends Specification {
  args(sequential = true)

  def config: Config = load(parseString(
    """
    bounded-mailbox {
      mailbox-type = "akka.dispatch.BoundedMailbox"
      mailbox-capacity = 100
      mailbox-push-timeout-time = 1ms
    }
    """))

  val system = ActorSystem("system", config)

  "some messages should go to dead letters" in {
    system.eventStream.subscribe(system.actorOf(Props(classOf[DeadLetterMetricsActor])), classOf[DeadLetter])
    val myTestActor = system.actorOf(Props(classOf[MyTestActor]).withMailbox("bounded-mailbox"))
    for (i  <- 0 until 3000) {
      myTestActor.tell("guestName", null)
    }
    Thread.sleep(100)
    system.shutdown()
    system.awaitTermination()
    DeadLetterMetricsActor.deadLetterCount.get must be greaterThan(0)
  }
}

class MyTestActor extends Actor {
  def receive = {
    case message: String =>
      Thread.sleep(500)
      println("message = " + message);
    case _ => println("Unknown Message")
  }
}

object DeadLetterMetricsActor {
  val deadLetterCount = new AtomicInteger
}

class DeadLetterMetricsActor extends Actor {
  def receive = {
    case _: DeadLetter => DeadLetterMetricsActor.deadLetterCount.incrementAndGet()
  }
}