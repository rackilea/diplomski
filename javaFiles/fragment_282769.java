Map<String, UserInfo> auctionAccounts;
// initialization, your other code ...
if(auctionAccounts.get(enteredUser) != null &&                       // user with entered username exists
   auctionAccounts.get(enteredUser).password.equals(enteredPass) {   // entered password is correct
    // SUCCESSFULL LOGIN
} else {
    // INVALID USERNAME or PASSWORD
}