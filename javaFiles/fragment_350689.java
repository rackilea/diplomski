boolean atLeastOneInvalid = false;
for(String phoneNumber : phoneNumbers){
   if(!validPhoneNumbers.contains(phoneNumber)){
      atLeastOneInvalid = true;
   }
}
// here if atLeastOneInvalid is true you know that some phone number(s) is not valid