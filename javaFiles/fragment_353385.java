play_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mp = MediaPlayer.create(MainActivity.this, songlist[selectedSong]);
        mp.setLooping(true);
        mp.start();
    }
});