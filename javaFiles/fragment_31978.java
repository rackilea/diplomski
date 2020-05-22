@Override
protected void onCancelled(Boolean aBoolean) {
    if(isCancelled() && mediaPlayer.isPlaying()) {
         mediaPlayer.stop();
    }
}