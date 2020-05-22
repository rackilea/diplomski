public class WLANService extends Service {
    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
            boolean connected = info.isConnected();
            if(connected) {
                Toast.makeText(context, "WIFI CONNECTED!", Toast.LENGTH_LONG).show();
                Log.i("Wi-Fi-State", "Wi-Fi is On!");
            } else {
                Toast.makeText(context, "WIFI DISCONNECTED!", Toast.LENGTH_LONG).show();
                Log.i("Wi-Fi-State", "Wi-Fi is Off!");
            }
        }
    }

    public WLANService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Service Created!", Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // registering your receiver
        registerReceiver(receiver, new IntentFilter(WifiManager.NETWORK_STATE_CHANGED_ACTION));
        return START_STICKY;
    }
}