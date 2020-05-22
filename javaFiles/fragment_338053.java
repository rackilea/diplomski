new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(Splash.this, "I will be called after 2 sec", 
                                                              Toast.LENGTH_SHORT).show();
                    //Call your Function here..
                }
            }, 2000); // 2000 = 2 sec