Button switchButton1 = (Button) findViewById(R.id.button1);
switchButton1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Caraga_Agusan_del_norte.class);
            startActivity(intent);

        }
    });