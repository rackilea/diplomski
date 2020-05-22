public class MainActivity extends AppCompatActivity {
    private TestService testService;
    private Subscriber subscriber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        bindService(new Intent(this, TestService.class),serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            testService = ((TestService.TestBinder)service).getService();
            subscriber = new ServiceSubscriber() {
                @Override
                public void messageCallback(String message) {
                    //I'm just printing out the message received 
                    //Be careful if you need to do UI stuff to use a 
                    //Handler
                    System.out.println(message);
                }
            }
            testService.subscribeToMessages(subscriber );
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

}