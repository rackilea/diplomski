new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {

            startActivity(new Intent(StartPage.this, NextPage.class));
            finish();
        }
}, 3000);