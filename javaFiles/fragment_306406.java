if (v == nextbuttonjava) {

    if(phnumberjava.getText().toString().length() < 10)
    {
        phnumberjava.setError("Invalid Phone Number");
    }
    else if(firstnamejava.getText().toString().isEmpty())
    {
        firstnamejava.setError("Whats your first name?");
    }
    else if(lastnamejava.getText().toString().isEmpty())
    {
        lastnamejava.setError("Whats your last name?");
    }
    else if(pickupaddressjava.getText().toString().isEmpty())
    {
        pickupaddressjava.setError("Enter your address");
    }
    else if(postalcodejava.getText().toString().length() < 6)
    {
        postalcodejava.setError("Invalid postal code");
    }
    else if(pickuptimejava.getText().toString().isEmpty())
    {
        pickuptimejava.setError("Enter pickuptime");
    }
    else if(numberstuffjava.getText().toString().isEmpty()) 
    {
        numberstuffjava.setError("Enter number of clothes");
    }
    else 
    {
        addInfo();
        Intent nextpageintent = new Intent(Afterfullscreen.this, Extrainformation.class);
        startActivity(nextpageintent);
    }
    else
    {
         //manage error case here
    }
}