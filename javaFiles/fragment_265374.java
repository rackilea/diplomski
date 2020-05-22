int currentPos = 0;
pause.setOnClickListener(new OnClickListener() {

    public void onClick(View v) {

        if (mediaPlayer.isPlaying()) {
            currentPos = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
            //change image to play
        } else {
            mediaPlayer.seekTo(currentPos);
            mediaPlayer.start();
            //again revert image to pause
        }  
    }
});