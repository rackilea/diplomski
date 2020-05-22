public class radio extends AppCompatActivity {

/** Called when the user touches the button */

public void playPauseMusic (View playPause) {
    String url = "http://streamer.cci.utk.edu:8000/wutk-vorbis"; // your URL here
    final MediaPlayer mediaPlayer = new MediaPlayer();

    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

        public void onPrepared(MediaPlayer mediaPlayer){
            mediaPlayer.start();
        }
    });


    if (mediaPlayer.isPlaying()) {
         mediaPlayer.pause();
         ((ImageButton)playPause).setImageResource(R.drawable.play1);
    } else {
        ((ImageButton)playPause).setImageResource(R.drawable.pause1);
    }

    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
    mediaPlayer.setDataSource(url);
    mediaPlayer.prepareAsync();
}

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_radio);
}
}