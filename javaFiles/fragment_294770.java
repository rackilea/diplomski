public class Song {
  // what you have here is fine, but what about some sort of id?
  // assuming the song title is the unique id for now
}

public class Genre {
  private String name;
  private Map<String, Song> songs; // where string is song title

  public Genre(String n, Map<String, Song> s) {
    name = n;
    songs = s;
  }
}

public class GenreBank {
  private Map<String, Genre> genres; // where string is genre name

  public GenreBank() {

     // If you did not understand how to physically build the maps, see here
     Map<String, Song> songList1 = new HashMap<String, Song>();
     songList1.put("title1", new Song(...));
     songList1.put("title2", new Song(...));

     Map<String, Song> songList2 = new HashMap<String, Song>();
     songList2.put("title3", new Song(...));
     songList2.put("title4", new Song(...));         

     genres = new HashMap<String, Genre>();
     genres.put("genre1", new Genre("genre1", songList1));
     genres.put("genre2", new Genre("genre2", songList2));
  }

  public Song getGenre(String genre) {
     return genres.get(genre);
  }

  public Song getSong(String title) {
    for (Genre g : genres.values()) {
      Song s = g.getSongs().get(title);
      if (s != null) { return s; }
    }
    return null;
  }

  public Song getSong(String genre, String title) {
     Genre g = genres.get(genre);
     if (g != null) {
        return g.getSongs().get(title);
     }
     return null;
  }
}