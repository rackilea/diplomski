public class SavingsAccount extends BankAccount {
  public BankAccount(double balanceIn, double withdrawIn) {
    super(balanceIn, withdrawIn);
  }

  // overwrite setWithdrawn
  @Override
  protected void setWithdrawn(double withdrawIn) {
    // do the specific stuff like the code of setWithdrawn in your post 
  }
}