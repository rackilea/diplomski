Map<String, Music> musics = new HashMap<>();
String musicPlaying = "music2";
musics.put("music1", new Music("blaalla"));
musics.put("music2", new Music("blalala"));
musics.put("music3", new Music("balaada"));

if(!musics.get(musicPlaying).stillPlaying) { // As you can see i am using string as a variable name.
  changeMusic();
}