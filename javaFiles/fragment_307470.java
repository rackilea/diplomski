public class SongDemo {
    public static void main(String[] args) {
        Song demoSong = new Song();

        // call the setters
        demoSong.setSongName("Summer of 69");
        demoSong.setYearReleased(1988);

        // call the getters and print the values returned
        System.out.println(demoSong.getSongName());
        System.out.println(demoSong.getYearReleased());
    }
}