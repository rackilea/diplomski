Map<String, Artist> artists = new HashMap<>();
for (Song song : songs) {
    for (String artistName : song.getArtists()) {
        Artist artist = artists.get(artistName);
        if (artist == null) {
            artist = new Artist(artistName, new ArrayList<>());
            artists.put(artistName, artist);
        }
        artist.Songs.add(song);
    }
}