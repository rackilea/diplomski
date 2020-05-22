package banking;

public class BankAccount {

    /**
     * The balance of this account. <br/>
     * Assumes integer money (Floating point math is horrible and who really
     * needs pesky pence or cents right?!)
     */
    private int balance;
    /**
     * The account number
     */
    private final int acctNum;
    /**
     * Name of the account holder
     */
    private final String name;

    /**
     * Construct our basic account with an account number, account holder and
     * starting balance.
     *
     * @param name
     * @param accNo
     * @param bal
     */
    public BankAccount(String name, int accNo, int bal) {
        this.name = name;
        this.acctNum = accNo;
        this.balance = bal;
    }

    /**
     * Make a deposit to this account by adding a fixed sum to the existing
     * balance. <br/>
     *
     * @param amount
     */
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("You cannot deposit zero or less");
        } else {
            this.balance += amount;
        }
    }

    /**
     * Make a withdrawal from this account by subtracting a fixed amount from
     * the existing balance. <br/>
     *
     * @param amount
     */
    public void withdraw(int amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient Funds");
        } else if (amount <= 0) {
            throw new IllegalArgumentException("You cannot withdraw zero or less");
        } else {
            balance -= amount;
        }
    }

    /**
     * Get the account holder name.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Get the current account balance.
     *
     * @return
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Get the account identifier for this account.
     *
     * @return
     */
    public int getAcctNum() {
        return acctNum;
    }

    /**
     * Debug print method.
     */
    public void display() {
        System.out.println("Name:" + name);
        System.out.println("Account No:" + acctNum);
        System.out.println("Balance:" + balance);
    }
}