Button logout=(Button) findViewById(R.id.logout)
    logout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(AccountActivity.this,MainActivity.class));
            finish();
        }
    });