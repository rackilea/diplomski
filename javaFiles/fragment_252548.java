b1 = (Button)findViewById(R.id.button_id);

b1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent2 = new Intent(IntentTest.this, IntentTest2.class);
            startActivity(intent2);
        }
    });