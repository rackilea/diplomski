@MessageDriven(
activationConfig = { 
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName="destination", propertyValue="foo")})
@ResourceAdapter(value="wmq.jmsra.rar")
public class MyMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {        
    }
}