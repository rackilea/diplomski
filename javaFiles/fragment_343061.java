public class ringtone_tab extends AppCompatActivity {

    Button clk1;
    Button clk2;
    Button clk3;
    Button clk4;
    Button clk5;
    Button clk6;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringtone_tab);


        clk6 = (Button) findViewById(R.id.btn_play6);

        clk5 = (Button) findViewById(R.id.btn_play5);

        clk4 = (Button) findViewById(R.id.btn_play4);

        clk3 = (Button) findViewById(R.id.btn_play3);

        clk2 = (Button) findViewById(R.id.btn_play2);

        clk1 = (Button) findViewById(R.id.btn_play1);

        mediaPlayer = new MediaPlayer();

    }


    public void setBtn_play6(View v)
    {
        stopPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shiv_vandana);
        mediaPlayer.start();

    }

    public void setBtn_play5(View v)
    {
        stopPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shiv_tandav_mantra);
        mediaPlayer.start();

    }



    public void setBtn_play4(View v)
    {
       stopPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shiv_shiv_om);
        mediaPlayer.start();

    }

    public void setBtn_play3(View v)
    {
        stopPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shiv_shiv);
        mediaPlayer.start();

    }



    public void setBtn_play2(View v)
    {
        stopPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shiv_aaradhna);
        mediaPlayer.start();


    }


    public void setBtn_play1(View v)
    {
        stopPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.shiv_shankar);
        mediaPlayer.start();
    }

    private void stopPlayer(){
        if(mediaPlayer != null && mediaPlayer.isPlaying())
        {mediaPlayer.stop();}
    }

    }