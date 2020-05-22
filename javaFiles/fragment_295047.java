Map<String, Artist> artists = new HashMap<>();
for (Song song : songs) {
    for (String artistName : song.getArtists()) {
        artists.computeIfAbsent(artistName, Artist::new).addSong(song);
    }
}