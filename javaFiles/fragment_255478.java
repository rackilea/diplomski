@Override
public void afterTextChanged(Editable s) {
    if (!isInAfterTextChanged) {
        isInAfterTextChanged = true;
        phoneNumberText.setText(pnu.updateNationalNumber(s.toString()));
        phoneNumberText.setSelection(this.phoneNumberText.getText().length());
        isInAfterTextChanged = false;
    }
}

 /**
 * Updates the national number based on the param s
 * Takes all formatting out of param s and then reformats the number
 * using the AsYouTypeFormatter for libphonenumber and based upon
 * the region code
 *  
 * @param s The formatted value to be used to update the national number
 * @return String The new formatted national number
 */
public String updateNationalNumber(String s){
    //Instantiate the as you type formatter with the current region (US or UK)
    aytf = phoneUtil.getAsYouTypeFormatter(this.currentRegionCode.getCountryCode());
    String fNationalNumber = null;

    //Format the string
    if(s.length() > 0){
        String digitString = null;
        //If it's in the US remove all leading 1s (international code)
        if(this.currentRegionCode == RegionCode.US){
            digitString = new String(s.replaceAll("(^[1?])|([^\\d.])", ""));
        }
        //If it's in the UK remove all leading 44s (international code)
        else if (this.currentRegionCode == RegionCode.GB){
            digitString = new String(s.replaceAll("(^[4?]{2})|([^\\d.])", ""));
        }
       if(digitString != null){
           //RE input all of the digits into the formatter
           for(int i = 0; i < digitString.length(); i++){
               fNationalNumber = aytf.inputDigit(digitString.charAt(i));
           }
       }

       //Clear the formatter for the next round of input
       aytf.clear();

       //Try to update the phone number with the formatted number
       try {
           phoneUtil.parse(fNationalNumber, this.currentRegionCode.getCountryCode(), this.uPhoneNumber);
       //Rejects if the number isn't in an acceptable format for the region code given etc.
       } catch (NumberParseException e) {
          System.err.println("NumberParseException was thrown: " + e.toString());
       }
    }
    //Return the formatted phone number
    return fNationalNumber;
}