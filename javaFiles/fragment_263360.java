@Override
protected void onPause() {
    super.onPause();
    if (mainmusic != null) {
        if (mainmusic.isPlaying())
            mainmusic.stop();
        mainmusic.reset();
        mainmusic.release();
    }
}