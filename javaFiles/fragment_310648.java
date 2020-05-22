public void playSong(int res)
{
    // here mp is still null
    mp = MediaPlayer.create(getApplicationContext(), resid[res]); // From here on we can use mp
    mp.start();
 }