private ArrayList<String> getSongsByArtist(String artist){
    ArrayList<String> songs = new ArrayList<String>();
    for (HashMap<String, String> hashMap : playListSongs) {
        if(hashMap.get(KEY_ARTIST).equals(artist)){
            songs.add(hashMap.get(KEY_TITLE));
        }
    }
    return songs;       
}