public static Collection<String> getTopTracks(String mArtistName) {
    String returnTopTrack = "";
    Collection<Track> top = Artist.getTopTracks(mArtistName, key);
    Collection<String> returnTopTracks = new ArrayList<String>();
    Iterator<Track> itr = top.iterator();
    while (itr.hasNext()) {          
        returnTopTrack = itr.next().getName();
        returnTopTracks.add(returnTopTrack);
        System.out.println(returnTopTrack);
    }
    return returnTopTracks;