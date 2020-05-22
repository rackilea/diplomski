public class Lagu {

MediaPlayer mPlayer;

public Lagu(){
    // do nothing or call initLagu() here
    // in this case skip the method call from the Activity's onCreate()
}

public void initLagu(Context theContext){
    mPlayer = Mediaplayer.create(theContext, R.raw.na);
}

public void playLagu(){

    mPlayer.start(); 
}