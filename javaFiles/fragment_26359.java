@Component
public class ReceiveMessage {
    @JmsListener(destination = "${jms.queue.destination}", containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(final String msg) throws Exception {
        System.out.println("Received:" + msg);
    }
}