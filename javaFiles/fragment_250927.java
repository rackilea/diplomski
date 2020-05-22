public void openActivity()
    {
        final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent go = new Intent(MainActivity.this,LoginPageActivity.class);
                         startActivity(go);
                        finish();

                    }
                }, 5000);
    }