private final int SPLASH_DISPLAY_LENGTH = 1000;


@Override
protected void onResume() {
    super.onResume();

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            MainActivity.this.finish();
            Intent mainIntent = new Intent(MainActivity.this, Main22Activity.class);
            startActivity(mainIntent);
        }
    }, SPLASH_DISPLAY_LENGTH);
}