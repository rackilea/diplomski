@MessageDriven(activationConfig={
                @ActivationConfigProperty(propertyName="destination",     propertyValue="myDestination"),
                @ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue")
})
public class MsgBean implements javax.jms.MessageListener {

  public void onMessage(javax.jms.Message msg) {

      String receivedMsg = ((TextMessage) msg).getText();
      System.out.println("Received message: " + receivedMsg);

   }

}