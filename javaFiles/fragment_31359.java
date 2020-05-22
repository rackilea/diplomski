public void forwardSong() {
    if (mPlayer != null) {
        int currentPosition = mPlayer.getCurrentPosition();
        if (currentPosition + seekForwardTime <= mPlayer.getDuration()) {
            mPlayer.seekTo(currentPosition + seekForwardTime);
        } else {
            mPlayer.seekTo(mPlayer.getDuration());
        }
    }
}