public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Vibrator vibrator = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
        MediaPlayer mPlayer = MediaPlayer.create(context, R.raw.aaanicholas);
        Vibrator v = (Vibrator) this.context.getSystemService(Context.VIBRATOR_SERVICE);
        final CheckBox vibrateBoxStrong = (CheckBox) findViewById(R.id.checkPowerStrong);


        vibrateBoxStrong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fansound1);
                    if(vibrateBoxStrong.isChecked()) {
                        v.vibrate(1000);            // it will vibrate for 1000 milliseconds
                        mPlayer.start();         
                    } else {
                        mPlayer.stop();

                        vibrator.cancel();
                    }
                }
            }
        );
    }
}