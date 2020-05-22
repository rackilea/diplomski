session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
consumer = session.createConsumer("MyQueue");
listener = new MyListener ();
consumer.setMessageListener(listener);
connection.start(); 
// At this point, messages should arrive from the queue to your listener.