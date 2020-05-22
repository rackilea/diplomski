public class Otp extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_otp);

    final ProgressBar simpleProgressBar = (ProgressBar) 
    findViewById(R.id.simpleProgressBar);
    Button startButton = (Button) findViewById(R.id.button);
    // perform click event on button
    startButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // visible the progress bar
            simpleProgressBar.setVisibility(View.VISIBLE);
        }
    });

// Your Resend OTP Button Code is below //

Button ResendButton = (Button) findViewById(R.id.but_resend);
ResendButton.setEnabled(false); // The button is initially disabled //
                        Timer buttonTimer = new Timer();
                        buttonTimer.schedule(new TimerTask() {

                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {

                                    @Override
                                    public void run() {
                                        ResendButton.setEnabled(true); // The button is enabled by the timer after 5 seconds //
                                    }
                                });
                            }
                        }, 5000); // Set your time period here //
}}