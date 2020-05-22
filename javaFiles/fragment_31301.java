private boolean validateNumberField(EditText editText){

    String entry = editText.getText().toString();

    String [] phoneNumbers = entry.split(","); // Seperate string on commas

    for(String phone : phoneNumbers){
        if( !hasCorrectDigitNumber(phone) ) {
            // Toast maybe?
            editText.setError(" The number field should have minimum 10 digits and a maximum of 15");
            return false;
        } 
    }

    return true;
}

private boolean hasCorrectDigitNumber(String phone){
    int count = 0;

    for(int i = 0; i < phone.length(); i++){
        char c = phone.charAt(i); 
        if(c <= '9' && c >= '0')
            count++;
    }

    return count >= 10 && count <= 15;
}