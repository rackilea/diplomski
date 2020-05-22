public static void BackgroundStop() {
        if (backgroundMusicPlaying == true) {
            backgroundMusic.stop();
            backgroundMusicPlaying = false;
        }
    }