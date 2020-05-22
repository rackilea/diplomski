QueueConnection queueConn = connFactory.createQueueConnection();
 QueueSession queueSession = queueConn.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
 QueueReceiver queueReceiver = 
    queueSession.createReceiver(queue, "ToAddress = 'John-123'");
 queueConn.start();
 TextMessage message = (TextMessage) queueReceiver.receive();