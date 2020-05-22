public class player1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player1);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.mozardpianosonata); //create mediaplayer with song
        ImageButton yButton = (ImageButton) findViewById(R.id.imageButton5);
        yButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) { //play music on click
                if (mp.isPlaying()) {
                    mp.pause();
                } else {
                    mp.start();
                }
            }
        });
    }
    @Override
    public void onBackPressed(){ //this is not working
                if(mp.isPlaying())
                {
                    mp.stop(); // stop music on backpress
                }
                //if you want to do the back action aswell, uncomment the following line
                //super.onBackPressed();
            }