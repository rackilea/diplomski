private void stopPlaying() {
    if (mp != null) {
        mp.stop();
        mp.release();
        mp = null;
    }
}