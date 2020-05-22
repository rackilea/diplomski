@Component
public class InputSource implements MessageSource<String>, Lifecycle {

    private boolean running;

    @Override
    public void start() {
        System.out.println("start");
        running = true;
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public Message<String> receive() {
        return new GenericMessage<String>("foo");
    }

    @Override
    public boolean isRunning() {
        return running;
    }

}