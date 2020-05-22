new Handler().postDelayed(new Runnable() {

        /*
         * Showing splash screen with a timer. This will be useful when you
         * want to show case your app logo / company
         */

        @Override
        public void run() {

            // This method will be executed once the timer is over
            // Start your app main activity
            Intent i;

            if (prefManager.isFirstTimeLaunch()) {
               i = new Intent(SpashScreen.this, WelcomeActivity.class);
               prefManager.setFirstTimeLaunch(false);
            } else {
               i = new Intent(SplashScreen.this, MainActivity.class)
            }

            startActivity(i);
            finish();
        }
    }, SPLASH_TIME_OUT);