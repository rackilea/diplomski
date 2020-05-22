Button button = (Button) findViewById(R.id.score);
 button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do your other functions //
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
            Intent i = new Intent(ActivityQuiz.this, MainActivity.class);
            startActivity(i);
            finish();
                    }
                }, 5000); // Set your time here //
            }
        });