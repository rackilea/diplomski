@MessageDriven(
    activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/amqmsg")
})
public class ExampleMessageBean implements MessageListener {

private BlockingQueue<Message> queue = new ArrayBlockingQueue<Message>() ; 

@Schedule(second="*", minute="*", hour="9-17", persistent = false)
public void process()
{
    //process queue here. 
}
public void onMessage(Message message) {
    try {
        System.out.println("We've received a message: " + message.getJMSMessageID());
        queue.add(message); 
        System.out.println("\n\n Message\n\n" + message);

    } catch (JMSException e) {
        e.printStackTrace();
    }
}