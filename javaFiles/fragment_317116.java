final EditText etxt = new EditText(this);
    etxt.setHint("Write something");
    Button btn = new Button(this);
    btn.setText("Send");

    btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String input = etxt.getText();
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("message", input.toString());
            startActivity(i);
        }
    });