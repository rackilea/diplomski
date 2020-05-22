public double transferSavingToChecking(double Tamount2) {
    //check if enough to transfer
    if(Tamount2 > Saving_Balance) {
        System.out.println("Transfer failed. You don't have enough     balance in the saving account!");
    } else {
        System.out.println("You have successfully transferred $" +     Tamount2 + " from the saving account to the checking account");
        Saving_Balance=Saving_Balance - Tamount2;
        Checking_Balance=Checking_Balance + Tamount2;
    }
    return Checking_Balance;
}