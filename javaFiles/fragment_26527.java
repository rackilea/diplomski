public void receiveJMS() throws NamingException, JMSException {
try{
     ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
     Connection connection = connectionFactory.createConnection();
     connection.start(); // it's the start point


     Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

     // Getting the queue 'testQueue'
     Destination destination = session.createQueue("testQueue");


     MessageConsumer consumer = session.createConsumer(destination);         

    // set an asynchronous message listener
   // JMSReceiver asyncReceiver = new JMSReceiver(); 
   //no need to create another object
    consumer.setMessageListener(this);

     connection.setExceptionListener(this);

     // connection.close(); once this is closed consumer no longer active

    Thread.sleep(60 *60 * 1000);             // receive messages for 1 hour
   }finally{
      connection.close();// after 1 hour close it
   }

}