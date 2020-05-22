public class MainActivity extends Activity {

    public MediaPlayer mediaPlayer = null;
    public Boolean playing=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button a = (Button) findViewById(R.id.First);
        a.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                (playing)mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.firstsound);
                mediaPlayer.start();
                            playing=true;
            }

        });

        Button b = (Button) findViewById(R.id.Second);
        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                (playing)mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.firstsound);
                mediaPlayer.start();
                            playing=true;
            }
        });
    }
}