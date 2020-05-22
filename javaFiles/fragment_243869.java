private Connection mConnection;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);



    EditText enter = (EditText) findViewById(R.id.searchbox);
    enter.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                EditText searchbox = (EditText) findViewById(R.id.searchbox);
                String search = searchbox.getText().toString();
                Intent open = new Intent(Intent.ACTION_WEB_SEARCH);
                open.putExtra(SearchManager.QUERY, search);
                startActivity(open);
                return true;
            } else {
                return false;
            }
        }
    });

    // Start your Service
    Intent msgIntent = new Intent(this, ConnectionChecker.class);
    startService(msgIntent);

    // Instanciate BCR
    mConnection = new Connection();
    // Register BCR
    IntentFilter filter = new IntentFilter(Connection.ACTION_RESP);
    registerReceiver(mConnection, filter);

}

public class Connection extends BroadcastReceiver {
    public static final String ACTION_RESP = "intent.action.MESSAGE_PROCESSED";

    @Override
    public void onReceive(Context context, Intent intent) {
        Integer connectionn = intent.getIntExtra("connection", 0);
        TextView connectiontext = (TextView) findViewById(R.id.connectiontext);

        if (connectionn == 1)
            connectiontext.setText("CONNECTION:You are not connected to the internet.");
        else
            connectiontext.setText("CONNECTION:You are not connected to the internet.");

    }
}

public void exit(View view) {
    finish();
    System.exit(0);
}

public void usernameclick(View view) {
    EditText searchbox = (EditText) findViewById(R.id.searchbox);
    String search = searchbox.getText().toString();
    Intent open = new Intent(Intent.ACTION_WEB_SEARCH);
    open.putExtra(SearchManager.QUERY, search);
    startActivity(open);

}