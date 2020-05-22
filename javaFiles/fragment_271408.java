if (mp.isPlaying()) {
    mp.stop();
    mp.prepareAsync();
    mp.seekTo(0);
} else {
    mp.start();
}