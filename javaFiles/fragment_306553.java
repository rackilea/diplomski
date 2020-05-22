new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (isOnline()) {    
                        Intent i = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(i);

                    } else {

                        //Toast t = Toast.makeText("test").show();
                        //Log.v("Home", "############################You are not online!!!!");
                        Intent i = new Intent(SplashScreen.this, chatonly.class);
                        startActivity(i);
                    }
            }
        }, 3000);