if(userLogInText.getText().toString().trim().length()>0 && userLogInText.getText().toString().trim().equalsIgnoreCase(name)){
            Intent intent = new Intent(getApplicationContext(),MyActivity.class);
            startActivity(intent);
 }
else {
             Toast.makeText(getApplicationContext(),"Registration ID is not Matching",Toast.LENGTH_LONG).show();
 }