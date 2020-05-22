if(mp.isPlaying()) { // mp only declared (still null)
    mp.reset();
    mp = MediaPlayer.create(getApplicationContext(), resid[res]);
    mp.start();     }

else {
    mp = MediaPlayer.create(getApplicationContext(), resid[res]);
    mp.start();
}