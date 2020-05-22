mPlayer = MediaPlayer.create(Splash.this, R.raw.happy_moments);
  mPlayer.start();
new Handler().postDelayed(new Runnable() {

                public void run() {

                    Intent i = new Intent("com.pack.prog.STARTINGMENU"); //<--- what ever which is right
                    startActivity(i); 
                }
            }, 2000);