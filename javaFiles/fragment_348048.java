x = Integer.parseInt(nop.getText().toString());
y = Integer.parseInt(cob.getText().toString());
 final TextView tv = (TextView) findViewById(R.id.textView);

    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          int z = x / y;
          tv.setText(z);
        }
    });