public class Music extends gameActivity{ 
Context context;

MediaPlayer menu;
MediaPlayer soundtrack;
MediaPlayer death;
MediaPlayer start;

 public Music(Context context){
       this.context =context; // initialising context here
      }

public void menuSound(boolean x) {
    if(menu == null) { 
        menu = MediaPlayer.create(context, R.raw.menumusic); // here context was causing null pointer exception as context was null
        menu.setVolume(100, 100); 
    } 

    if(x) 
        menu.start(); 
    if(!x) 
        menu.stop(); 
}