public String listProjectedPortfolioTimeframe(double desiredBalance) {
    desiredBalance = 88;
    String str = "";
    double num = 200;
    if (bankAccounts.size() <= 0) {
        str = "enter ammount to find number of years of constant saving will give 200 euro";
        for (BankAccount ba: bankAccounts) {
            str += ba.getAccNumber();
            str += ba.getBalance();
        }
    } else {
        str = String.valueOf(num * 100);
    }
    return str;
}