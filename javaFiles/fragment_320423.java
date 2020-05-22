private int SPLASH_TIME_OUT=10000;  // for 10 seconds 

new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                    // Code here what you want before redirecting
                    // e.g. hide picture you showed

                    Intent intent = new Intent(CurrentActivity.this, SecondGame.class);
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(SplashScreen.this);
                    startActivity(intent, options.toBundle());
                    finish();

            }
        },TIME_OUT);   // parameter to show for a particular time

    }