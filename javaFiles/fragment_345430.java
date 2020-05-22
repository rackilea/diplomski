mediaPlayer.setOnPreparedListener(new OnPreparedListener(){

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.start();
    }
});