protected void onPostExecute(String result) {

     if(result.equals("success"))
        {
            Intent mainintent=new Intent(LoginActivity.this, MainActivity.class);
            startActivity(mainintent);
            finish();
            //error.setText("Correct Username or Password");
        }
        else
        {
            /*Toast.makeText(getApplicationContext(), "Sorry!! Incorrect Username or Password", Toast.LENGTH_LONG).show();
            editTextUsername.setText("");
            editTextPassword.setText("");
            editTextUsername.requestFocus();*/
            error.setText("Sorry!! Incorrect Username or Password");

        }


    pDialog.dismiss();
}