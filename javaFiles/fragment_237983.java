try {           
        MessageConsumer consumer = session.createConsumer(testQueue);
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                try {
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        String text = textMessage.getText();
                        System.out.println("Consuming["+threadId+"] message: " + text);

                        if(text.contains("RD")){
                            System.out.println("acknowledgeThisMessage");
                            ((com.sun.messaging.jms.Message)message).acknowledgeThisMessage();
                        } else{
                            System.out.println("recovering the message");
                            session.recover();
                        }
                    }
                    else{
                        System.out.println("Consuming["+threadId+"] Weird Message: " + message);
                    }
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    } catch (JMSException e) {
        e.printStackTrace();
    }