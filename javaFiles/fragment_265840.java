SharedPreferences prefs = getSharedPreferences("my_pin_pref", MODE_PRIVATE); 
String mysavedpin = prefs.getString("pin", "");

Button okButton = (Button) findViewById(R.id.okbutton);
    okButton.setOnClickListener(new View.OnClickListener() {        
        public void onClick(View v){
        EditText passwordEditText = (EditText) findViewById(R.id.pinedittext);
                    if(passwordEditText.getText().toString().equals(mysavedpin)){
                        startActivity(new Intent("com.my.activtyToBeOpened"));
                    }
                    else{
                       //add some code to display error message
                    }
}});