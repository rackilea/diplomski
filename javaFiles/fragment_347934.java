public void displaySound(Context context) {
    if (mPlayer != null && mPlayer.isPlaying()) {
        mPlayer.stop();
        mPlayer.reset();
    }
    mPlayer = MediaPlayer.create(context, R.raw.bubble_nice);
    mPlayer.start();
}