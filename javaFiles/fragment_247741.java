public class MyActivity extends Activity {

    private final Context context = this;

    private static Handler mHandler = new Handler();

    private final Runnable timeoutRunnable = new Runnable(){
        @Override
        public void run() {
            showTimeoutAlertDialog();
        }
    };
    private final Runnable disconnectRunnable = new Runnable(){
        @Override
        public void run() {
            disconnect();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setTimeout();
    }

    private void disconnect() {
        Log.e("MyActivity", "Disconnected");
    }

    private void setTimeout(){
        mHandler.postDelayed(timeoutRunnable, 5000);
    }

    private void showTimeoutAlertDialog(){

        new AlertDialog.Builder(context)
                .setTitle("Disconnect in 5s")
                .setCancelable(false)
                .setPositiveButton("Abort",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                mHandler.removeCallbacks(disconnectRunnable);
                                setTimeout();
                            }
                        }).show();

        mHandler.postDelayed(disconnectRunnable, 5000);
    }
}