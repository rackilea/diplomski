MediaPlayer ourSong;
@Override
protected void onCreate(Bundle LW) {
    // TODO Auto-generated method stub
    super.onCreate(LW);
    setContentView(R.layout.splash);
    MediaPlayer ourSong = MediaPlayer.create(Splash.this, R.raw.drum);
    ourSong.start();