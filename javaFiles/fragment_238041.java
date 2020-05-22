final MediaPlayer mp = MediaPlayer.create(this, R.raw.kalas); 
ImageButton sound1=(ImageButton) findViewById(R.id.sound1); 
ImageButton sound2=(ImageButton) findViewById(R.id.sound2); 

sound1.setOnClickListener(new View.OnClickListener() { 
    @Override public void onClick(View v) { 
        // TODO Auto-generated method stub 
        if (mp.isPlaying()) { 
            mp.pause(); 
            mp.seekTo(0); 
        } 
        else { 
            mp.start(); 
        } 
    } 
}); 

sound2.setOnClickListener(new View.OnClickListener() { 
    @Override public void onClick(View v) { 
        // TODO Auto-generated method stub 
        if (mp.isPlaying()) { 
            mp.stop
        } 

    } 
});