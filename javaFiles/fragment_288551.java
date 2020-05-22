new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(MainActivity.this,ListViewActivity.class));
        }
    }, duration);