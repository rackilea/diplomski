static  MediaPlayer intro;

 @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_level_one);
    getReadyTimeText = (TextView) findViewById(R.id.levelonetimerText);

 public void OneGame(){
    intro = MediaPlayer.create(getApplicationContext(), R.raw.minicycleaudio);


}