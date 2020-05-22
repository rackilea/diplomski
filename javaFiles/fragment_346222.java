public class MainActivity extends Activity {
    Timer myTimer;
    TimerTask doThis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTimer = new Timer();
        int delay = 0;   // delay for 30 sec.
        int period = 1000;  // repeat every 60 sec.
        doThis = new TimerTask() {
          public void run() {

                         Log.v("TImer","repeated");

          }
        };

        myTimer.scheduleAtFixedRate(doThis, delay, period);
    }

    @Override
    protected void onPause() {
        myTimer.cancel();
        super.onPause();
    }
}