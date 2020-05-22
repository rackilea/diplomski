@Singleton
public class NSQRunner extends UntypedActor{    
    public static final String name = "NSQRunner";

    ...

    @Override
    public void onReceive(Object msg) throws Throwable {
        if(msg instanceof NSQRunnerProtocol.StartConsumer){
            startNSQConsumer();
        } else {
            unhandled(msg);
        }

    }

    private void startNSQConsumer() {
        ...
    }
}