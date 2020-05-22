import akka.actor.{Actor, ActorLogging}

  class EchoActor extends Actor with ActorLogging {

    log.info("Actor created {}", self.path.name)

    def receive = {
      case message: Message =>
        log.info("Received message {} in actor {}", message.consistentHashKey(),             self.path.name)
      case _ => log.error("Received unsupported message");
    }
  }