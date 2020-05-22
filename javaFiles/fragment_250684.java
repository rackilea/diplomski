Performs a JNDI lookup of the ConnectionFactory and Destination.
Creates a Connection and a Session.
Creates a MessageConsumer:

consumer = session.createConsumer(dest);
Starts the connection, causing message delivery to begin:

connection.start();
Receives the messages sent to the destination until the end-of-message-stream control message is received:

while (true) {
  Message m = consumer.receive(1);
  if (m != null) {
    if (m instanceof TextMessage) {
      message = (TextMessage) m;
      System.out.println("Reading message: " +
        message.getText());
    } else {
      break;
    }
  }
}

Because the control message is not a TextMessage, the receiving program terminates the while loop and stops receiving messages after the control message arrives.
Closes the connection in a finally block, automatically closing the session and MessageConsumer.