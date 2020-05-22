try {
    account.withdraw(passNegative);
} catch(NegativeWithdraw e) {
    System.out.println(e.getMessage());
} catch(NotEnoughBalance e) {
    System.out.println(e.getMessage());
}