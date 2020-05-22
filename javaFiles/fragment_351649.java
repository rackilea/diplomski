...
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
EditText Seconds;
Seconds =(EditText)findViewById(R.id.Seconds);

WifiManager wm = (WifiManager)getSystemService(Context.WIFI_SERVICE);
Handler handler = new Handler();
SocketThread thread = new SocketThread(handler, wm);
thread.start();
...