public class BankAccount {
  public BankAccount(double balanceIn, double withdrawIn) {
    balance = balanceIn;
    setWithdrawn(withdrawIn);
  }

  protected void setWithdrawn(double withdrawIn) {
    // do the base stuff like withdraw = withdrawIn;
  }
}