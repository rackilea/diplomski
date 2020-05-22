MQQueueConnectionFactory connectionFactory = new MQQueueConnectionFactory();
connectionFactory.setHostName(<hostname>);
connectionFactory.setPort(<port>);
connectionFactory.setTransportType(JMSC.MQJMS_TP_CLIENT_MQ_TCPIP);
connectionFactory.setQueueManager(<queue manager>);
connectionFactory.setChannel("SYSTEM.DEF.SVRCONN");

QueueConnection queueConnection = connectionFactory.createQueueConnection();
QueueSession queueSession = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

Queue queue = queueSession.createQueue(<queue name>);

QueueSender queueSender = session.createSender(queue);
QueueReceiver queueReceiver = session.createReceiver(queue);