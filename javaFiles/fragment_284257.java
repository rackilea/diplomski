public class MainActivity extends AppCompatActivity {

    //THIS IS YOUR LAST MISTAKE. IF YOU TRY TO CREATE THE OBJECT WITH THE CONTEXT AND THE RESOUERCES
    //WHEN THE ACTIVITY IS NOT CREATED YET, YOUR APP CRASH
    //private MediaPlayer policeSound = MediaPlayer.create(this, R.raw.police);
    private MediaPlayer policeSound;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button policeSounds = this.findViewById(R.id.police);

        policeSounds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (policeSound == null) {
                    policeSound = MediaPlayer.create(getApplicationContext(), R.raw.police);
                }

                if (policeSound.isPlaying()) {
                    policeSound.pause();
                } else {

                    policeSound.start();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (policeSound != null) {
            policeSound = MediaPlayer.create(this, R.raw.police);
            policeSound.start();
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        if (policeSound.isPlaying())
            policeSound.pause();
    }

    //Back button pressed.
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (policeSound.isPlaying())
            policeSound.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        policeSound.stop();
        policeSound = null;
    }
}