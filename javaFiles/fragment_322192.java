public class MessageReceiverBean implements MessageListener {

public void onMessage(Message message) {
          try {
            if (message instanceof TextMessage) {
                TextMessage textMsg = (TextMessage) message;
                logger.info("Inside onMessage of client app MessageReceiverBean : " + textMsg.getText());
     }
  }
          catch (Exception er) {
            logger.error("Error while retrieving message from Service provider", er);
        }
}
}