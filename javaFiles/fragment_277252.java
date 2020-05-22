public void onClick(View view) {
    boolean found = false;
    String myUsername = username.getText().toString();
    String myPassword = password.getText().toString();

    for (int i = 0; i < use.length; i++) {
      if (use[i].equals(myUsername) && pas[i].equals(myPassword)) {
             Toast.makeText(PassActivity.this,"You have Authenticated Successfully",Toast.LENGTH_LONG).show();
           found = true;
           break;
      }
     }

     if (!found) {
          Toast.makeText(PassActivity.this,"Authentication Failed",Toast.LENGTH_LONG).show();
      }
  }