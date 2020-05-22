sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
    @Override
    public void onCompletion(MediaPlayer mp) {
        playBtn.setBackgroundResource(R.drawable.playicon);
    }
});