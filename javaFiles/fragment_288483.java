List<AlbumWrapper> wrappers = getIntent().getParcelableArrayListExtra("ALBUM_WRAPPERS");
List<Album> albums = new ArrayList<>();

for (AlbumWrapper wrapper : wrappers) {
    Album album = Album.getInfo(wrapper.artist, wrapper.mbid, YOUR_API_KEY);
    albums.add(album);
}