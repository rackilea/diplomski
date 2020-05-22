for(int i = 0; i < albumsCollection.size();i++) {
    Album album = albumsCollection.get(i); 
    System.out.println(album.getArtistName() + ":" + album.getAlbumTitle()); 

    List<Tracks> tracks = album.getTracks(); 
    for(int j = 0; j < tracks.size(); j++) {
        System.out.println(tracks[j].toString());
    }
}