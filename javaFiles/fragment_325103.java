btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ScanActivity.class);
            startActivityForResult(intent, 500) //500 is our request code, we will use this to check if incoming data is what we want. You can put any integer value in it
        }
    });