public class MainActivity extends Activity {
Button button1;
MediaPlayer mediaPlayer = null;
private final Random mRandom = new Random();
int delayMillis;
Handler handler;
Runnable runnable;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    button1 = (Button) findViewById(R.id.button1);
    handler = new Handler();
    runnable = new Runnable() {

        @Override
        public void run() {
            mediaPlayer.start();

        }
    };
    button1.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            toggleMediaPlayer();

        }
    });
}

private void toggleMediaPlayer(){
    if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
            handler.removeCallbacks(runnable);
    }else{
        mediaPlayer = MediaPlayer.create(this, R.raw.hangouts_incoming_call);
        mediaPlayer.setOnPreparedListener(new OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();

            }
        });
        mediaPlayer.setOnCompletionListener(new OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                delayMillis = 1000 * mRandom.nextInt(5) + 6;
                handler.postDelayed(runnable,delayMillis);
            }
        });

    }
}}