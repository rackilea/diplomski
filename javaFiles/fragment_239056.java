public class test {

    private void playSound39() {
        try {
            /**
             * Sound player code from:
             * http://alvinalexander.com/java/java-audio-example-java-au-play-sound
             */
            // the input stream portion of this recipe comes from a javaworld.com article.
            InputStream inputStream = getClass().getResourceAsStream("/bark.wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Audio file not found!");
        }
    }
    public static void main(String[] args){
        new test().playSound39();
    }
}