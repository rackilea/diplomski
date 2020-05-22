ArrayList<AlbumWrapper> wrappers = new ArrayList<>();

for (Album album : albums) {
    AlbumWrapper wrapper = new AlbumWrapper(album);
    wrappers.add(wrapper);
}

intent.putParcelableArrayListExtra("ALBUM_WRAPPERS", wrappers);