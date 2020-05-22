Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            EditText edit = (EditText) findViewById(R.id.editText);
            if (edit.getText().toString().equals("admin")) {
                Intent gz = new Intent(getApplicationContext(), gz.class);
                startActivity(gz);
            }

        }
    });