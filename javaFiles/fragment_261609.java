do {
    try {
        String BankTransaction = getInitialSelection();

        if (isDepositRequest(BankTransaction)) {
            handleDeposit();
        } else if (isWithdrawalRequest(BankTransaction)) {
            handleWithdrawal();
        } 
    } catch (InputMismatchException | NumberFormatException exception1) {
        System.out.println("This is not what you should have put in");
    } catch (InsufficientFundsException exception2) {
        System.out.println("insufficientfunds!");
    } catch (MaximumWithdrawException exception3) {
        System.out.println("Maximum withdraw restriction!");
    }
} while (!isExitRequest(BankTransaction));
System.out.println("Thank you for using our service.");