if (numx > numy) {
    EditText mNumXEdit = (EditText) findViewById("etnumx");
    mNumXEdit.RequestFocus(); // focus the View

    // sends Toast notification to user in order to alert him he needs to take action
    Toast.makeText(getApplicationContext(), 
        "[ENTER MESSAGE]", 
        Toast.LENGTH_LONG).show(); 
}