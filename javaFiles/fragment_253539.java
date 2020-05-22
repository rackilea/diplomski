public void pause() {
    mMediaPlayer.pause();

    stopForeground(false);

    nManager.notify(NOTIFICATION_ID, Build_Notification());

    if (mCallback != null) {
        mCallback.onPlayPause(false);
    }
}