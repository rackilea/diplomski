...
}else if ((Homeno.equals("")) && (MobileNo.equals("")) && (Email.equals("")) ) {
    Toast.makeText(getApplicationContext(), 
    "Please enter at least one (1) your contact information.", Toast.LENGTH_SHORT).show();
} else{

    if (Homeno.length()<9) {
        Toast.makeText(getApplicationContext(), 
        "Invalid Telephone Number!", Toast.LENGTH_SHORT).show();
    }

    //Mobile Number must be at least 12
    if ( (MobileNo.length()<12) {
        Toast.makeText(getApplicationContext(), 
        "Mobile Number must be 12 digits!", Toast.LENGTH_SHORT).show();
    }

    //Mobile Validator
    if (!validcp.matches()) {
        Toast.makeText(getApplicationContext(), 
        "Invalid Mobile Number!", Toast.LENGTH_SHORT).show();
    }

    //Email validator
    if (!matcherObj.matches()) {
        Toast.makeText(getApplicationContext(), 
        "Invalid Email Address!", Toast.LENGTH_SHORT).show();
    }
}