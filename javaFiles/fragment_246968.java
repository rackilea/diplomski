setContentView(R.layout.splash_activity.xml);
    mRelativeLayout = findViewById(R.id.root);
    pref = this.getSharedPreferences("myAppPref",MODE_PRIVATE);
    String color = pref.getString("splashColor","your default color here ex : #000000");
    mRelativeLayout.setBackgroundColor(Color.parseColor(color));

    Handler handler = new Handler();
    int Delay = 3000; // choose ur own delay

    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    },Delay);