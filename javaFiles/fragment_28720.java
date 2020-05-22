Button Btn2 = (Button) findViewById(R.id.Btn2);
    Btn2.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            shouldPlay = true;
            startActivity(intent);
        }
    });