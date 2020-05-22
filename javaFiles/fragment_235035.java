@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);

    new Handler().postDelayed(new Runnable() {

        @Override
        public void run() {                
            startActivity(new Intent(SplashScreen.this, MainActivity.class));
            finish();
        }
    }, 4000);
}