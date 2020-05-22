ConnectionFactory factory = getJMSConnectionFactory();
   Connection connection = factory.createConnection();
   Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
   Queue queue = session.createQueue("MyQueue");
   MessageConsumer consumer = session.createConsumer(queue);
   connection.start();
   Message message = consumer.receive();