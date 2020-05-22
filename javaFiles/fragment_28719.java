public void onStop() {
    super.onStop();
    if (!shouldPlay) { // it won't pause music if shouldPlay is true
        player.pause();
        player = null;
    }
}