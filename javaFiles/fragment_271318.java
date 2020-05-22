public void playTrack(int index)
{
    if(indexValid(index)) {
        Track track = tracks.get(index);
        stopPlaying();
        player.startPlaying(track.getFilename());
        track.incrementCount();
        System.out.println("Now playing: " + track.getArtist() + " - " + track.getTitle());
    }
}