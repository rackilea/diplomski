//Main.java
AccountLogger accountLogger = new AccountLogger();
AccountMaker accountMaker = accountLogger.getAccountMaker();

//AccountLogger.java
public AccountMaker getAccountMaker()
{
    return accountMaker;
}