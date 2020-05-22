public void playSong(int songIndex)
{
    if(mp.isPlaying()) {
        mp.pause(); // Pause the current track
    }

    mp.selectTrack(songIndex); // Select the requested track
    mp.start();
}