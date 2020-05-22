public class MainController {

    private MediaPlayer player ;

    // ...

    public void selectTrack() {
        URL[] songs = new URL[] { ... } ;
        final Media media = new Media(songs[Integer.parseInt(number.getText())].toString());
        this.player = new MediaPlayer(media);
    }

    public void play() {
        // stop current player:
        if (player != null) {
            player.stop();
        }
        selectTrack();
        player.play();
    }

    public void stop() {
        player.stop();
    }
}