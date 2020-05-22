public class SongManager {

   private static SongManager sMan;

   private Map<String, Song> songs = new HashMap<String, Song>();

   public static SongManager getInstance() {
       if (sMan == null) {
           sMan = new SongManager();
       }
       return sMan;
   }

   public void addSong(Song s) {
       songs.put(s.getName, s);
   }

   public Song getSong(String name) {
       return songs.get(name);
   }

}