while(true) {
       QCon.start();

       queue = ((AQjmsSession) session).getQueue(queueUserName, queueName);
       MessageConsumer consumer = session.createConsumer(queue);       

       consumer.setMessageListener(a);
       QCon.setExceptionListener(a);

       consumer.close();
}