public class MainActivity extends AppCompatActivity {

MediaPlayer mediaPlayer = null;
int delayMillis;
Handler handler;
Runnable runnable;
private boolean isToggleChecked;
private ToggleButton toggleButton;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    toggleButton = findViewById(R.id.button);

    handler = new Handler();
    runnable = new Runnable() {
        @Override
        public void run() {
            mediaPlayer.start();

        }
    };


    toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                isToggleChecked = true;
                toggleMediaPlayer();
            }
            else {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer=null;
                handler.removeCallbacks(runnable);
                isToggleChecked = false;
            }
        }
    });
}

@Override
public void onResume() {
    super.onResume();
    if (isToggleChecked) {
        toggleButton.setChecked(true);
    }
    else {
        toggleButton.setChecked(false);
    }
}

private void toggleMediaPlayer(){
    if(mediaPlayer != null){
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer=null;
        handler.removeCallbacks(runnable);
    }else{
        mediaPlayer = MediaPlayer.create(this, R.raw.beat);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                delayMillis = 1000;
                handler.postDelayed(runnable,delayMillis);
            }
        });

    }
}
}