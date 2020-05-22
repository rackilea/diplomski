private void handleSplashScreen(boolean showSplash){
    if(showSplash) { //splash screen code in `if`
        splashImageView = new ImageView(this);
        //splashImageView.setBackgroundColor();
        splashImageView.setImageResource(R.drawable.sexy);
        setContentView(splashImageView);
        splashloading = false;
        Handler h = new Handler();

        h.postDelayed(new Runnable() {
           public void run() {
               handleSplashScreen(false);
           }
        }, 3000);
    }
    else{
        splashloading = false;
        setContentView(R.layout.activity_registration);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }
}