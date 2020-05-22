@Override
public void onMessage(Message message) {
    try {
        count++;
        TextMessage msg = (TextMessage) message;
        System.out.println("Message Received " + msg.getText());
        System.out.println("Message received from " + msg.getStringProperty("SentToNode"));
        //now you can send the message to that node

    } catch (JMSException e) {
        e.printStackTrace();
    }
}