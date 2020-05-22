@ManagedBean
public class Bean {

    private String username; // +getter+setter
    private String password; // +getter+setter

    @Resource
    private DataSource dataSource;

    public void login() {
        try (
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE username = ? AND password = MD5(?)");
        ) {
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Login.
                }
            }
        }
    }

    // ...
}