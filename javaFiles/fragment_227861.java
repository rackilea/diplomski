public void onClick(View v) {
    //what code do i enter here to read in and send rowid to the db class
    //..this code:
    String userInput = edit1.getText().toString();

    //if the ROW ID its a number (long)
    try{
        long rowID = Long.parseLong(userInput);
        //call the delete method
        deleteContact(rowID);
    }catch(NumberFormatException e){
        Log.e("INPUT ERROR","Input is not a number!",e);
        //notify the user that the input is invalid.
        Toast.makeText(this,"Invalid Value!",Toast.LENGTH_LONG).show();
    }
}