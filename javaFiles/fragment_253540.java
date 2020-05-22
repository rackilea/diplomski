Button button1 = (Button) findViewById(R.id.button1);
            button1.setOnClickListener(new OnClickListener(){
                public void onClick (View v){
                    EditText editText1 =(EditText) findViewById(R.id.editText1);
                    String pin = editText1.getText().toString();

     AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

                        dlgAlert.setMessage("PIN VERIFICATION");
                        dlgAlert.setTitle("Is that your PIN code -"+pin );
                        dlgAlert.setPositiveButton("OK", null);
                        dlgAlert.setCancelable(true);
                        dlgAlert.create().show();

                        dlgAlert.setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
      String encodedHash = Uri.encode("#");
                    String ussd = "*" + "124" + pin + encodedHash;
                    Intent button1 = new Intent(android.content.Intent.ACTION_CALL, Uri.parse("tel:" + ussd));      
                    startActivity(button1);


                            }
                        });
  dlgAlert.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                  editText1 .setText(" ");
                }
            });