public class CustomerAccount {

    private final String accountId; // account number is final, it should never be updated
    private int amount;

    // Constructor with two paremeters
    public CustomerAccount(String accountId, int initialAmount) {
        this.accountId = accountId;
        this.amount = initialAmount;
    }

    // Funcionality : deposits to the amount
    // Returns      : latest amount
    public int deposit(int adjustment) {
        this.amount = amount + adjustment;

        return this.amount;
    }

    // Funcionality : witdraws from the amount
    // Returns      : latest amount
    public int withdraw(int adjustment) {
        this.amount = amount - adjustment;

        return this.amount;
    }

    // getters

    public String getAccountId() {
        return this.accountId;
    }

    public int getAmount() {
        return this.amount;
    }

}