...
MediaPlayer mediaPlayer = new MediaPlayer(hit);
// each time you hit a button, you create a new MediaPlayer

        if (actionEvent.getSource() == playbtn) {
            mediaPlayer.play();
            // first time, you call play, so it plays
            nowPlaying.setText("Now Playing");
            songPlayingName.setText("Sing");

        } else if (actionEvent.getSource() == pausebtn) {
            // pause does work, but it is not the same instance that is playing
            mediaPlayer.pause();
        }
    ...