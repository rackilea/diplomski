if (loginDataBaseAdapter.getPassthruSecInfo(secretInfo).toString().equals("")){

     loginDataBaseAdapter.insertEntry(password);
     Toast.makeText(getApplicationContext(), "Account Successfully Created",Toast.LENGTH_LONG).show();
                         }

if(!loginDataBaseAdapter.getPassthruSecInfo(secretInfo).toString().equals(""))

     Toast.makeText(getApplicationContext(), "Account Already Exists",Toast.LENGTH_LONG).show();

                     }