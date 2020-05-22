public class Song {

// ...

public static Comparator<Song> getAlbumComparator() {
    return new Comparator<Song>() {
        public int compare(YourClass one, YourClass two) {
            return(songA.getAlbum().compareTo(songB.getAlbum());
        }
    };
}

// Other comparators
}