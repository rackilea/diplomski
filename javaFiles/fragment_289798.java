userdatabase name = new userdatabase(Editprofile.this);
    name.open();
    String user = name.getusername();
    name.close();

    EditText cinone = (EditText) findViewById(R.id.username);
            username = cinone.getText().toString();

  if(user.equals("")){

        //your code here
    }

    else {
          //your code here
    }