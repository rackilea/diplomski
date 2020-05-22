if (mViewPager.getCurrentItem() == 0) {
          if(mp != null && mp.isPlaying()){
              mp.pause();
           length = mp.getCurrentPosition();

             }else{

             mp = MediaPlayer.create(MainActivity.this, R.raw.aa);
             mp.seekTo(length);

             mp.start();
             }             

          }