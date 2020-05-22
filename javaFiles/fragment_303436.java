public class UserDAO implements IDao<User> {

    DemoDB DemoDBSingleton = null;

    public UserDAO() {
        DemoDBSingleton = DemoDB.getInstance();
    }

    @Override

    public boolean login(String userName, String password) throws NoSuchElementException {
        boolean login = false;
        try {
            ResultSet resultSet = DemoDBSingleton
                    .excecuteQuery("SELECT user_name, password FROM users WHERE user_name='" + userName + "' AND password = '" + password + "'");
            if (resultSet.next())
                login = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DemoDBSingleton.close();
        return login;
    }
}