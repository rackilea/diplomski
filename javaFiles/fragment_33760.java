// Step 5. Create a JMS Session
 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

 // Step 6. Create a JMS Message Producer
 MessageProducer producer = session.createProducer(queue);

 // Step 7. Create a JMS MessageConsumer

 MessageConsumer consumer1 = session.createConsumer(queue);

 // Step 8. Start the connection

 connection.start();

 // Step 9. Send 10 messages to the queue

 final int numMessages = 10;

 for (int i = 0; i < numMessages; i++)
 {
    TextMessage message = session.createTextMessage("This is text message: " + i);

    producer.send(message);
 }


 System.out.println("Sent messages");

 // Step 10. Create another consumer on the same queue

 MessageConsumer consumer2 = session.createConsumer(queue);

 // Step 11. Consume three messages from consumer2

 for (int i = 0; i < 3; i++)
 {
    TextMessage message = (TextMessage)consumer2.receive(2000);

    System.out.println("Consumed message from consumer2: " + message.getText());
 }