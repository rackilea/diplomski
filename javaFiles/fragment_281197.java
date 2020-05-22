public class PlayaudioActivity extends Activity {

    private MediaPlayer mp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    Button b = (Button) findViewById(R.id.button1);

    b.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
        stopPlaying();
        mp = MediaPlayer.create(PlayaudioActivity.this, R.raw.tosse);
        mp.start();
        }

    });


    }

    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
       }
    }
}