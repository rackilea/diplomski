public UserBean getUserDevices(final String emailAddress, final String uuid) throws SQLException {
    UserBean userBean = null;

    String query = "SELECT user.id, user.emailAddress, device.uuid, device.active, device.user_id FROM user " +
            "LEFT JOIN device ON user.id = device.user_id AND device.uuid = ? " +
            "WHERE user.emailAddress = ?";

    try (Connection connection = dataSource.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query);
    ) {
        preparedStatement.setString(1, uuid);
        preparedStatement.setString(2, emailAddress);

        try(ResultSet resultSet = preparedStatement.executeQuery();) {
            while(resultSet.next()) {
                if(userBean == null) { // initialize user once while iterating for devices
                    userBean = new UserBean(resultSet.getInt("user.id"), resultSet.getString("user.emailAddress"), null);
                }
                if(resultSet.getString("device.uuid") != null) { // if device exists (it's a LEFT JOIN) then add
                    userBean.getDevices().add(new DeviceBean(0, resultSet.getString("device.uuid"), resultSet.getBoolean("device.active"), resultSet.getInt("device.user_id")));
                }
            }
        }
    }
    return userBean;
}