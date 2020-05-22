protected void onPostExecute(String file_url) {
    // dismiss the dialog once done
    pDialog.dismiss();
 if (success == 1) {
          tvLError.setText("Successfully logged in!");

 }else{
       tvLError.setText("Incorrect username/password");

     }

}