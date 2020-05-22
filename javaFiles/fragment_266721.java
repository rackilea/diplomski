MediaPlayer media;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Your initialization code goes here:
    media = MediaPlayer.create(this, R.raw.button);
    media.start();
}