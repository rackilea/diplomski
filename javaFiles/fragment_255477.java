@Override
public void afterTextChanged(Editable s) {
    if (!isInAfterTextChanged) {
       isInAfterTextChanged = true;

       if(s.length() > 0){
           Log.v("AsYouTypeFormatter - source", s.toString());
           unformattedPhoneNumber = s.toString().replaceAll("[^\\d.]", "");
           for(int i = 0; i < unformattedPhoneNumber.length(); i++){
               formattedPhoneNumber = aytf.inputDigit(unformattedPhoneNumber.charAt(i));
               Log.v("AsYouTypeFormatter - formatted", formattedPhoneNumber);

           }
           Log.v("AsYouTypeFormatter - source after loop", s.toString());

           phoneNumberText.setText(formattedPhoneNumber);
           aytf.clear();
       }

       formattedPhoneNumber = null;
       isInAfterTextChanged = false;
   }
}