while(mPlayer.isPlaying()) {
          if(mPlayer.getCurrentPosition() > 7254 && mPlayer.getCurrentPosition() < 7410 ){ 
              labelTxt.setText("Stop: " + mPlayer.getCurrentPosition() );
              mPlayer.stop();
              break;
          }
        }