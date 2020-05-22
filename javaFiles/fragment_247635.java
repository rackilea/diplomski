String  radioUrl = "http://s26.myradiostream.com:9406/listen.pls";

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(radioUrl);
        mediaPlayer.prepare();
        mediaPlayer.start();