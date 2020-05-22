public void postData(){
.
.
.
.
      String callbackURL = tokens.nextToken();
      String donationId = tokens.nextToken();
      examplePayment(callbackURL, donationId);
}

private void examplePayment(String callback, String donationid){
      //deal with your callback and donationid variables
}