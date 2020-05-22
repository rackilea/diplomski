Queue q = (Queue) ServiceLocator.getInstance().getDestination("QUEUE");
    QueueConnectionFactory factory = (QueueConnectionFactory) ServiceLocator.getInstance().getConnectionFactory(
            "java:/ConnectionFactory");
    QueueConnection connection = factory.createQueueConnection();
    QueueSession session = null;
    QueueSender sender = null;
    session = connection.createQueueSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
    sender = session.createSender(q);
    ObjectMessage msg = session.createObjectMessage();
    if (redelivedCount > 0) {
      msg.setIntProperty("redelivedCount", redelivedCount);
      // schedule to run in 10 secs
      msg.setLongProperty("_AMQ_SCHED_DELIVERY", System.currentTimeMillis() + 10000);
    }
    msg.setStringProperty("action", action);
    msg.setObject(params);
    sender.send(msg);