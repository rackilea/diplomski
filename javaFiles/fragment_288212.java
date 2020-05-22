public void toggleMusic() {
    Prefs.toggleMusic();
    if (!Prefs.isMusicOn()) {
        music.stop();
    } else {
        music.play();
    }
}