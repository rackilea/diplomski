public interface AccountObserver{

   public void withdrawl(IAccount from, BidDecimal amount);

   public void deposit(IAccount to, BigDecimal amount);

}