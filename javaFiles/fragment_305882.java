mediaPlayer.setOnEndOfMedia(new Runnable() {
    @Override
    public void run() {
        playing = false;
    }
});

mediaPlayer.setOnReady(new Runnable() {
    @Override
    public void run() {
        mediaPlayer.play();
        playing = true;
    }
});