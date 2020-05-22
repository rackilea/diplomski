public void musicPlay(View view) {
    Button music = (Button) findViewById(R.id.music);
        if(isPlaying) {
            music.setPressed(true);
            MusicManager.release()
        }else{
            music.setPressed(false);
            MusicManager.start(this);
        }
    isPlaying = !isPlaying;
}