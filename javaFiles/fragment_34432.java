@Component
public class MyComponent {

    @ServiceActivator(inputChannel = "inputChannel")
    public void onMessage(Message message) throws Exception {
        //handle sqs message
    }

}