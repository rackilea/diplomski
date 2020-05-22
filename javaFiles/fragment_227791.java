public interface AccountDAO {

    @Mapper(AccountMapper.class)
    @SqlQuery("SELECT Account.id, Account.name, User.id as u_id, User.name as u_name FROM Account LEFT JOIN User ON User.accountId = Account.id WHERE Account.id = :id")
    public List<Account> getAccountById(@Bind("id") int id);

}