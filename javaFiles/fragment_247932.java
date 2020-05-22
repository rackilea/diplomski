public void goReceipt(View v) 
 {
    try {
            int number = Integer.parseInt(((EditText) findViewById(R.id.guest)).getText().toString());
            if (number > 50 && number <= 10000) {
                Intent intent = new Intent(v.getContext(), doReceipt.class);
                intent.putExtra("phone", phone.getText().toString());
                startActivityForResult(intent,0);
            } else {
                Toast msg = Toast.makeText(getBaseContext(), "Maximum 10000 only.",
                        Toast.LENGTH_LONG);
                msg.show();
            } 
    } catch (Exception ex) {}

 }