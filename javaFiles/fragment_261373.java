//Main.java
AccountMaker accountMaker = new AccountMaker();
AccountLogger accountLogger = new AccountLogger(accountMaker);

//AccountLogger.java
class AccountLogger
{
    private AccountMaker accountMaker;

    public AccountLogger(AccountMaker maker)
    {
        accountMaker = maker;
    }
}