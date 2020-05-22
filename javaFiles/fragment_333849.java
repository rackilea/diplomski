private String[] songPaths;
private int playingPostion=0;

public void play(){
   if(mediaPlayer==null){
      mediaPlayer=new MediaPlayer();
   }else{
      mediaPlayer.reset();
   }
   //your array contains resource files.First convert them to a uri before submitting to the mediaPlayer
   String uri = "android.resource://" + getPackageName() + "/"+songPaths[playingPosition];
   mediaPlayer.setDataSource(Uri.parse(uri));
   mediaPlayer.prepare();
   mediaPlayer.start();
   //prepare your textviews and seekbar

   //prepare the player to play next song from array after completing current song
   if(playingPosition==0){
     if(songPaths.length>1){
        playingPosition++;
     }
   }else if((playingPosition+1)==songPaths.length){
        playingPosition=0;
   }else{
        playingPostion++;
   }

   mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    play();
                    //do anything else you desire
                }
            });  
}