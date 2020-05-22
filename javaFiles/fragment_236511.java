new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                   balls[1] = new Ball (this,images[1]); 
            }
        }, 5000); //in milliseconds - the code inside run() will run after 5 seconds