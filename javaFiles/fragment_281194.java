@Override 
protected void onPause() 
{ 
    super.onPause(); 
    if ((play!= null) && (play.isPlaying())) 
    { 
        // play.pause(); 
    } 
}