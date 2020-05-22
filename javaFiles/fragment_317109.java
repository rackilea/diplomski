Queue managementQueue = HornetQJMSClient.createQueue("hornetq.management");
     QueueRequestor requestor = new QueueRequestor(session, managementQueue);
     Message m = session.createMessage();
     JMSManagementHelper.putOperationInvocation(m,
                                                "jms.queue.exampleQueue",
                                                "removeMessages","*");
     Message reply = requestor.request(m);
     boolean success = JMSManagementHelper.hasOperationSucceeded(reply);