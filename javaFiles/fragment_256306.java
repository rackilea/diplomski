play=findViewById(R.id.play);

mediaPlayer = MediaPlayer.create(MainPlay.this, R.raw.click);
play.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(mediaPlayer!=null)
           mediaPlayer.start();

});