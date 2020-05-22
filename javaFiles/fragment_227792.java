public abstract class AccountDAO {

    @Mapper(AccountMapper.class)
    @SqlQuery("SELECT Account.id, Account.name, User.id as u_id, User.name as u_name FROM Account LEFT JOIN User ON User.accountId = Account.id WHERE Account.id = :id")
    protected abstract List<Account> _getAccountById(@Bind("id") int id);

    public Account getAccountById(int id) {
        List<Account> accountList = _getAccountById(id);
        if (accountList == null || accountList.size() < 1) {
            // Log it or report error if needed
            return null;
        }
        // The mapper will have given a reference to the same value for every entry in the list
        return accountList.get(accountList.size() - 1);
    }
}