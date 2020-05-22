public class SavingsAccount extends BankAccount {
    public int amt;
    public float interest;    

    public BankAccount(int accountNumber, int amt, float interest) {
        super(accountNumber);
        this.amt = amt;
        this.interest = interest;
    }

}