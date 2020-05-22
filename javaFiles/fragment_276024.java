public class AudioPlayer {
   boolean isPaused = false;

   public void pause() {   
     if(mPlayer.isPlaying())  {
           mPlayer.pause();
           isPaused = true;
     }
   }

  public void play(Context c) {
   if (isPaused && mPlayer != null) {
       mPlayer.start();
       isPaused = false
       return;
   }
   stop();
   mPlayer = MediaPlayer.create(c, R.raw.one_small_step);