public class MainActivity extends AppCompatActivity implements pacioWebSocketListener.MessageListener {


    TextView  tv;  



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // Pass "this" in the constructor, to show that this activity is
        // Listening for changes   
        pacioWebSocketListener myWS = new pacioWebSocketListener(this);

        tv = findViewById(R.id.textView);
     }
 // Override the method in MessageListener Inteface
 public void onMessageReceived(String message){
          // Then from here you can update your UI
          tv.setText("Message: " + message);
 }