public void sorea (View v)
{
    Button button = (Button)findViewById(R.id.Sorea);
    final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
    button.startAnimation(myAnim);
    if (player == null){

  //Call the StopPlaying() to release player
  stopPlaying();
  player = MediaPlayer.create(this, R.raw.sorea);
  player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlayer();
            }
        });
    }
    player.start();
}

 private void stopPlaying() {
        if (player != null) {
            player.stop();
            player.release();
            player= null;
       }
    }