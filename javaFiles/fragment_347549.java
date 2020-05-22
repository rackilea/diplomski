if(accountType.equals("Basic")){
    basicAccount account = new basicAccount();
    this.account = account; // This works! Don't worry!
}
else if(accountType.equals("Premium")){
    premiumAccount account = new premiumAccount();
    this.account = account;
}