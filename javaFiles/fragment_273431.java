public void displayAllAlbums() {
    for (int i = 0; i < AlbumList.size(); i++) {
        Album album = AlbumList.get(i)
        System.out.println(album.getTitle() + " "+ album.getPrice());
    }
}