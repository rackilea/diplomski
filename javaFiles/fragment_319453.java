b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Intent intent = new Intent(signup.this,MainActivity.class);
            //startActivity(intent);
            finish(); //<<<<<<<<<< Proper way to return
        }
    });