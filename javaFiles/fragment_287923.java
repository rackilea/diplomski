public class MyActor extends UntypedAbstractActor {

    private MyClient client;

    @Inject
    public MyActor(MyClient client) {
        this.client = client;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        client.sendRequest();
    }
}