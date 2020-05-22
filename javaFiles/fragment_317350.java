private ArrayList<String> getDistinctArtists(){
    HashMap<String,String> duplicateTracker = new HashMap<String, String>();
    ArrayList<String> distinctArtists = new ArrayList<String>();
    for (HashMap<String, String> hashMap : playListSongs) {
        // Check whether artist is already added or not
        if(duplicateTracker.containsKey(hashMap.get(KEY_ARTIST))==false){
            //Add artist name to hash map
            duplicateTracker.put(hashMap.get(KEY_ARTIST), hashMap.get(KEY_ARTIST));
            distinctArtists.add(hashMap.get(KEY_ARTIST));
        }
    }
    return distinctArtists;     
}