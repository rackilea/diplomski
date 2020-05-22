new Handler().postDelayed(new Runnable() {  
        @Override
        public void run() {
            //I want to display this images in 2 second count
            ivLogoText.setVisibility(View.VISIBLE);
            ivLogoStem.setVisibility(View.VISIBLE);
 }
    }, (long) (2 * 1000));

 new Handler().postDelayed(new Runnable() {  

            //I want to display this image in 3 second count
            ivSmLeaves.setVisibility(View.VISIBLE);
 }
    }, (long) (3 * 1000));

new Handler().postDelayed(new Runnable() {  

            //I want to display this image in 4 second count
            ivMedLeaves.setVisibility(View.VISIBLE);
    }, (long) (4 * 1000));

new Handler().postDelayed(new Runnable() {  

            //I want to display this image in 5 second count
            ivLargeLeaves.setVisibility(View.VISIBLE);

            startActivity(new Intent(SplashScreen.this, HomeLeftPanel.class));
            finish();
        }
    }, (long) (5 * 1000));