prof_sub_btn = (Button) findViewById(R.id.prof_sub_btn);
prof_sub_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(MainActivity.this, profile.class);
            startActivity(i);
        }
    });