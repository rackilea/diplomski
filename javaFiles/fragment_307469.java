public class Song {
    private String songName;
    private int yearReleased;

    // Getter method for Song Name
    public String getSongName() {
        System.out.println("Getting the song name.");
        return songName;
    }
    // Getter method for Year of Release
    public int getYearReleased() {
        System.out.println("Getting the year of release.");
        return yearReleased;
    }

    // Setter method for Song Name
    public void setSongName(String mySong) {
        System.out.println("Setting the song name.");
        this.songName = mySong;
    }
    // Setter method for Year of Release
    public void setYearReleased(int mySongYear) {
        System.out.println("Setting the year of release.");
        this.yearReleased = mySongYear;
    }

}