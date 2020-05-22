new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent start = new Intent(StartActivity.this, MainActivity.class);
            startActivity(start);
            finish();
        }
    }, 5000);