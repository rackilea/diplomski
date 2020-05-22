public class AccountMapper implements ResultSetMapper<Account> {

    private Account account;

    // this mapping method will get called for every row in the result set
    public Account map(int index, ResultSet rs, StatementContext ctx) throws SQLException {

        // for the first row of the result set, we create the wrapper object
        if (index == 0) {
            account = new Account(rs.getInt("id"), rs.getString("name"), new LinkedList<User>());
        }

        // ...and with every line we add one of the joined users
        User user = new User(rs.getInt("u_id"), rs.getString("u_name"));
        if (user.getId() > 0) {
            account.getUsers().add(user);
        }

        return account;
    }
}