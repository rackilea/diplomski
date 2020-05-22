public class MainActivity extends AppCompatActivity {

    private CountdownTimer timer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar sb = (SeekBar) findViewById(R.id.seekBar);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {}

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                restartTimer(seekBar);
            }
        }

    final Button bt_stop = (Button) findViewById(R.id.btn1);
    bt_stop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(timer != null) {
                timer.cancel();
            }
        }
    });


    }    

    private void restartTimer(SeekBar sb) {
        if(timer!=null) {
            timer.cancel();
        }
        final long millis = TimeUnit.SECONDS.toMillis(sb.getProgress());
        final long interval =  TimeUnit.SECONDS.toMillis(1);
        timer = new CountdownTimer(millis, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv.setText(String.format("Seconds Remaining: %d", TimeUnit.MILLIS.toSeconds(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                tv.setText("done!");
            }
        }
        timer.start();
    }

}