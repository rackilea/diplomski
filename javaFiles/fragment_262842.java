public class MediaplayerActivity extends Activity implements OnCompletionListener 
    {

        @Override
        protected void onCreate(Bundle savedInstanceState) {

        mMediaPlayer.setOnCompletionListener(this);
        }

        @Override
        public void onCompletion(MediaPlayer mp) {

        .
        .
        .
         mediaPlayer = mediaPlayer.create(Servicio_Reproductor.this, MainActivity.uri);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mMediaPlayer.setOnCompletionListener(this);
                    mediaPlayer.start();
                }
            });

        }
    }