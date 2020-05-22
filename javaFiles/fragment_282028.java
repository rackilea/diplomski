if (!uname.getText().toString().matches("[cC][0-9]{7}") || 
    uname.getText().toString().equals(test) ||
    uname.getText().toString().equals(test2) ) {

     uname.setError("Incorrect ID Format" );
}