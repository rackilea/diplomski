for(UserInfo createdUser : auctionAccounts){
    if(enteredUser.equals(createdUser.userName) && enteredPass.equals(createdUser.passWord)){
        System.out.println("Welcome: " +createdUser.userName);
        returnToMenu();                 
    }
}
// if this point is reached, then username and pw are invalid
System.out.println("Username or Password is wrong!");