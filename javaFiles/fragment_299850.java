@EnableIntegration
@MessageEndpoint
@Component
public class InputSource implements SmartLifecycle {

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

    @InboundChannelAdapter(value = "toRabbit", poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "1"))
    public Message<?> read() {
        return new GenericMessage<String>("foo");
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public int getPhase() {
        return 0;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        stop();
        callback.run();
    }

}