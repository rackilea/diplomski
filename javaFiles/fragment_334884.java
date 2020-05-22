public void exitFullscreen(){

 if (adPlayer != null) {
          adPlayer.setFullscreen(false);
        }
        contentPlayer.setFullscreen(false);
        //again after this calls you will see that your callback method onReturnFromFullscreen() will be called  
     }
 }