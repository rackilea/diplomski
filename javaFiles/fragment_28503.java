// instance variables
    String bip = getClass().getResource("Songs/Sing.m4a").toExternalForm();
    Media hit = new Media(bip);
    MediaPlayer mediaPlayer = new MediaPlayer(hit);

public void audioPlayerButtons(ActionEvent actionEvent) {        

    if (actionEvent.getSource() == playbtn) {
        mediaPlayer.play();

        nowPlaying.setText("Now Playing");
        songPlayingName.setText("Sing");

    } else if (actionEvent.getSource() == pausebtn) {
        mediaPlayer.pause();


    } else if (actionEvent.getSource() == forwardbtn) {
        mediaPlayer.stop();

    } else if (actionEvent.getSource() == backwardbtn) {
        mediaPlayer.isAutoPlay();
    }

}