public class MyIntentService extends IntentService {

    // You must have a parameter-less ctor for an IntentService
    public MyIntentService() {
        super("MyIntentService");
    }

    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        // This method is run on a separate worker thread so it's
        // safe to put all of your network code here

    }
}