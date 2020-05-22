class Account
{
    private int id;
    private String accountNo;
    private String legencyNo;

    public Account(String accountNo, String legencyNo)
    {
        this.accountNo = accountNo;
        this.legencyNo = legencyNo;
    }

    @Override
    public String toString()
    {
        return this.accountNo + " " + this.legencyNo;
    }
}