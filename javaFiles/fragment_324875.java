public UserBean getUser(String userName) throws SQLException {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    UserBean userBean = null;

    String sql = "select userId, userName, userPwd from admin where userName = ?";

    try {
        connection = dataSource.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setString(1, userName);
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            userBean = new UserBean();
            userBean.setUserId(resultSet.getInt("userId");
            userBean.setUserName(resultSet.getString("userName"));
            userBean.setUserPwd(resultSet.getString("userPwd"));
        }
    } finally {
        if (resultSet != null) try { resultSet.close(); } catch (SQLException logOrIgnore) {}
        if (statement != null) try { statement.close(); } catch (SQLException logOrIgnore) {}
        if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
    }

    return userBean;
}