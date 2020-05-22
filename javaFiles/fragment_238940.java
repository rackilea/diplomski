import groovy.beans.ListenerList

interface MessageListener {
  void messageReceived(byte[] msg)
}

class MessageProducer {
  @ListenerList
  List<MessageListener> listeners

  void produce(String msg) {
    fireMessageReceived(msg.getBytes())
  }
}

producer = new MessageProducer()
producer.addMessageListener({ println it } as MessageListener)
producer.produce('Groovy')