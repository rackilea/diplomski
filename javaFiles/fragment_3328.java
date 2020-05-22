ConnectionFactory factory = getJMSConnectionFactory();
   Connection connection = factory.createConnection();
   Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
   Queue queue = session.createQueue("MyQueue");
   MessageProducer producer = session.createProducer(queue);
   connection.start();
   Message message = session.createTextMessage("hello world!");
   producer.sendMessage(message);