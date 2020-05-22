public class CheckingAccount extends BankAccount {
    public int amt;

    public CheckingAccount(int accountNumber, int amt) {
        super(accountNumber);
        this.amt = amt;
    }

}