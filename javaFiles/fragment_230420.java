public void playSong(int songIndex) {

    mp.reset();
    mp = MediaPlayer.create(this, arrayAdapter.getItem(songIndex).getResId());

    mp.start();
}