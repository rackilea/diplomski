Bundle b = getIntent().getExtras();
String total = b.getString("GrandTotal");
TextView grandtotal = (TextView) findViewById(R.id.grand_total);
grandtotal.setText("Welcome ," + total );   

  if(isUserValidated && isPasswordValidated)  {      
      Intent intent = new Intent(CustomerLogin.this,PayPalIntegrationActivity.class);
      intent.putExtra("GrandTotal", total);
      intent.putExtra("login",username.getText().toString());
      startActivity(intent);    
    }