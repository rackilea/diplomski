// Create JMS objects
 connection = cf.createConnection();
 System.out.println("Created connection to " + queueManager);
 // Create a transacted session.
 session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
 System.out.println("Session created");

 Destination topicScore = session.createTopic("/SCORE");
 MessageConsumer consScore = session.createConsumer(topicScore );

 JMSBytesMessage msg=null;
 // Receive message first
 msg = (JMSBytesMessage) colesConsumer.receiveNoWait();
 System.out.println(msg.getJMSRedelivered);

 // Rollback the previous receive, to force messaging provider to redeliver the message
 session.rollback();

 // receive message again
 msg = (JMSBytesMessage) colesConsumer.receiveNoWait();
 // This time JMSRedelivered will be true.
 System.out.println(msg.getJMSRedelivered);