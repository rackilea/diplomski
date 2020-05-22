public class PlayInterval extends Activity {
   private Handler customHandler;
   Boolean isRunning;
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_playinterval);
      final ImageButton playPauseButton = (ImageButton)findViewById(R.id.playPauseButton);//Play/Pause
      playPauseButton.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
            onPlayPauseClicked(playPauseButton);
         }
      });
      customHandler = new Handler();
      isRunning=true;
      new Thread(new Task()).start();
   }

   @Override
   public void onBackPressed() {
      customHandler.removeCallbacksAndMessages(null);
      finish();
   }

   class Task implements Runnable {
      @Override
      public void run() {
      if (isRunning == true){
         // Do really cool stuff
         // and even cooler stuff
      } else {
         // it is paused
      }
      customHandler.postDelayed(this, 100);
   }


   private syncronized void onPlayPauseClicked(ImageButton playPauseButton) {
     if (isRunning==true) {
        isRunning=false;
        playPauseButton.setImageResource(getResources().getIdentifier("play_image", "drawable", getPackageName()));
     } else {
        isRunning=true;
        playPauseButton.setImageResource(getResources().getIdentifier("pause_image", "drawable", getPackageName()));
      }
  }
}