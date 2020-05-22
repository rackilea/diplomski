final TextView tv = (TextView) findViewById(R.id.textView);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try{
                x = Integer.valueOf(nop.getText().toString());
            } catch (NumberFormatException e) {
                x = 0;
            }

            try{
                y = Double.valueOf(cob.getText().toString());
            } catch (NumberFormatException e) {
                y = 1.00;
            }

             Double z = (y / x);
            tv.setText("You will each pay:" + (z));
        }
    });