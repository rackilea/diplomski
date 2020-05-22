OtpErlangString convertedString;
if(messageData.elementAt(2).toString().equals("[]")) {
    // do something assigning some value to convertedString
} else {
    convertedString = (OtpErlangString) messageData.elementAt(2);
}