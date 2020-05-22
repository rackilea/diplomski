public static void displayMainMenu() {
    SavingsAccountUgang savingsAccount = null // don't create object here as you are doing
    // Your code
    if (option == 1) {
        savingsAccount = newAccount();
    }
    if (option == 2) {
        if(savingsAccount  == null) {
            // throw exception or whatever you want to do.
        }
        savingsAccount.balanceInquiry();
    }
}