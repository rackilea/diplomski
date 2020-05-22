public class MyEventListener implements MessageListener {

  @Override
  public void onMessage(Message message) {
    try {
      if (message instanceof TextMessage) {
        TextMessage textMessage = (TextMessage) message;
        String stringMessage = textMessage.getText();
        //do something with your message from queue
      }
    } catch (JMSException e) {
      //catch error
    }
  }
}