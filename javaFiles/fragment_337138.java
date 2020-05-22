try {
     account.withdraw(passNegative);
}
catch(NegativeWithdraw | NotEnoughBalance e) {
    System.out.println(e.getMessage());
}