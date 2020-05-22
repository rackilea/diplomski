songManager = new SongsManager();
        utils = new Utilities();

        songProgressBar.setOnSeekBarChangeListener(this); 


        songsList = songManager.getPlayList();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getInt("songIndex");
        }

        //playSong(value); 

        if (mp != null){ 
          try { 
             mp.relase(); 
             mp = null; 
          } catch (Exception e) { 

          } 

        mp = new MediaPlayer(); 
        playSong(value); 
      }else{ 
        mp = new MediaPlayer(); 
        playSong(value); 
      }

        mp.setOnCompletionListener(this); // Important