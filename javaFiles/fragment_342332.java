public class MainActivity extends Activity {

private Gpio mtrGpio;
private GestureDetector mtrbtnGD;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button mtrbtnGD = (Button) findViewById(R.id.mtrbtn);
    try {
      PeripheralManager manager = PeripheralManager.getInstance();
      mtrGpio = manager.openGpio("BCM24");
      mtrGpio.setEdgeTriggerType(Gpio.EDGE_NONE);
      mtrGpio.setActiveType(Gpio.ACTIVE_HIGH);
      mtrGpio.setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);
    } catch (IOException e) {
      throw new IllegalStateException("cannot open gpio", e);
    }

    mtrbtnGD.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            try {
               switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // PRESSED
                        mtrGpio.setValue(true);
                        Log.i(TAG, "Motor started");
                        return true; 
                    case MotionEvent.ACTION_UP:
                        // RELEASED
                        mtrGpio.setValue(false);
                        return true; 
                }
            } catch (IOException e) {
                Log.w(TAG, "Unable to access GPIO", e);
            }
           return true;
        }
    });
}

@Override
protected void onDestroy() {
   try {
      mtrGpio.close();
   } catch (IOException ignore) {
      Log.w(TAG, "Unable to close GPIO", ignore);
   }
   super.onDestroy();
}