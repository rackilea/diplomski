class BankAccount {
    private static int nextAccountNumber = 0;

    static int getNewAccountNumber() {
        int newNumber = nextAccountNumber;
        nextAccountNumber++;
        return newNumber;
    }

    ...

    BankAccount() {
        this.accNum = getNewAccountNumber();
    }
}