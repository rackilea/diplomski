public void Start(View view) {
     final Handler handler = new Handler();
     Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Integer count = a;
            String sec = count.toString();
            timer = findViewById(R.id.textView);
            timer.setText(sec);

            if (run) {
                a++;
            }

            handler.postDelayed(this, 1000);
        }
    };


    handler.postDelayed(runnable, 1000);
}