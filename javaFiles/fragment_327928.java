Master eMaster = new Master();
    eMaster.setF();
    //add Files here 

    QueueSender queueSender = queueSession.createSender(queue1);
    ObjectMessage objMessage = queueSession.createObjectMessage();
    objMessage.setObject(eMaster);
    queueSender.send(objMessage);