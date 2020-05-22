public boolean findSongInAlbum(String songName) {
    for (int i = 0; i < this.albumContainingListOfSongs.size(); i++) {
        if (songName.equals(albumContainingListOfSongs.get(i).getTitle1())) {
            System.out.println("Album song found: " + albumContainingListOfSongs.get(i).toString());
            return true;
        }
    }
    System.out.println("Album song not found");
    return false;
}