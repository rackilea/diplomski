public void onClick(View v) {

    if (v == nextbuttonjava) {
        boolean error = false;

        if(phnumberjava.getText().toString().length() < 10)
        {
            error = true;
            phnumberjava.setError("Invalid Phone Number");
        }
        if(firstnamejava.getText().toString().isEmpty())
        {
            error = true;
            firstnamejava.setError("Whats your first name?");
        }
        if(lastnamejava.getText().toString().isEmpty())
        {
            error = true;
            lastnamejava.setError("Whats your last name?");
        }
        if(pickupaddressjava.getText().toString().isEmpty())
        {
            error = true;
            pickupaddressjava.setError("Enter your address");
        }
        if(postalcodejava.getText().toString().length() < 6)
        {
            error = true;
            postalcodejava.setError("Invalid postal code");
        }
        if(pickuptimejava.getText().toString().isEmpty())
        {
            error = true;
            pickuptimejava.setError("Enter pickuptime");
        }
        if(numberstuffjava.getText().toString().isEmpty()) 
        {
            error = true;
            numberstuffjava.setError("Enter number of clothes");
        }
        if(!error)
        {
            addInfo();
            Intent nextpageintent = new Intent(Afterfullscreen.this, Extrainformation.class);
            startActivity(nextpageintent);
        } else {
             //manage error case here
        }
    }
}