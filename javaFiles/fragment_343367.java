Handler handler = new Handler();
handler.postDelayed(
    new Runnable()
    {
        @Override
        public void run()
        {
            startActivity(...insert code here...);
            finish();
        }
    },
    2600 * 1000 /* ms */);