public class MyActivity extends Activity implements IWorker {
    private NotificationReceiver receiver;

    @override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create the receiver
        receiver = new NotificationReceiver(this);

        IntentFilter filter = new IntentFilter();
        filter.addAction(NotificationReceiver.ACTION1);
        filter.addAction(NotificationReceiver.ACTION2);

        // register it
        registerReceiver(receiver, filter);
    }        

    @override
    protected void onDestroy() {
        super.onDestroy();

        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
    }

    @override
    public void doThis() {
        System.out.println("Doing this...");
    }

    @override
    public void doThat() {
        System.out.println("Doing that...");
    }
}