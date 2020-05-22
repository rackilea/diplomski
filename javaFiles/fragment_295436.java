public class Transaction  {
    private String name;
    private Account account ;
    private BigDecimal ammout ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getAmmout() {
        return ammout;
    }

    public void setAmmout(BigDecimal ammout) {
        this.ammout = ammout;
    }
}