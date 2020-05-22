import rx.lang.scala.{Observable, Subscriber}

case class Message(message: String)

trait MessageCallback {
  def onMessage(message: Message)
}

object LibraryObject {
  def setCallback(callback: MessageCallback): Unit = {
    ???
  }

  def removeCallback(callback: MessageCallback): Unit = {
    ???
  }

  def start(): Unit = {
    ???
  }
}

def messagesSource: Observable[Message] =
  Observable((subscriber: Subscriber[Message]) ⇒ {
    val callback = new MessageCallback {
      def onMessage(message: Message) {
        subscriber.onNext(message)
      }
    }
    LibraryObject.setCallback(callback)
    subscriber.add {
      LibraryObject.removeCallback(callback)
    }
  })