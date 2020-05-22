mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
  @Override
  public void onCompletion(MediaPlayer mp) {
            //custom method to play next song
            playNextSong();        
  }
});