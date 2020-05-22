public void fire(View v){
    MediaPlayer mp = MediaPlayer.create(Main.this, R.raw.pistol);
    mp.start();
    Toast.makeText(this, "shot fired", Toast.LENGTH_SHORT).show();
    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mp.stop();
        if (mp != null) {
            mp.release();
        }

      }
    });
}