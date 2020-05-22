words.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), WordsActivity.class);
            startActivity(intent);
        }
    });