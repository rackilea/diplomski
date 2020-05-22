public class DemoApplication {

    public static void main(String[] args) {
        String filename = ("Growth.mp3");
        MP3 mp3 = new MP3(filename);
        mp3.playForever();
    }
}