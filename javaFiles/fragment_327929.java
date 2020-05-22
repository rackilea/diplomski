Master em =null;
        Message message = queueReceiver.receive(1);
        if (message instanceof ObjectMessage
                && ((ObjectMessage) message).getObject() instanceof Master) {
            em = (Master) ((ObjectMessage) message).getObject();
            //use this and get list of xml file and iterate and process xml file by 
            //below link
        }