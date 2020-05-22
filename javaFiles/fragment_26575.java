InvalidationListener listener = new InvalidationListener() 
        {
            public void invalidated(Observable ov) {

                someMethod();

            }
        };
someMediaPlayer.currentTimeProperty().addListener(listener);
....
someMediaPlayer.currentTimeProperty().removeListener(listener);