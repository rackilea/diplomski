public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ....
    play.setEnabled(false);


....

mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
    @Override
    public void onPrepared(MediaPlayer mp) {
        play.setEnabled(true);
    }
});