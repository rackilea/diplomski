//public Role getRole(int roleId) throws SQLException {
public Optional<Role> getRole(int roleId) {
    try (Connection connection = dataSource.getConnection();
            PreparedStatement statement =
                connection.prepareStatement(
                "select ROLE_ID, ROLE_TEXT from ROLES WHERE ROLE_ID = :1")) {
        statement.setInt(1, roleId);
        try (ResultSet rs = statement.executeQuery()) {
            if (rs.next()) {
                return roleMapper.mapRow(rs, 1);
            }
        }
    } catch (SQLException e) { //
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, "ID: " + roleId, e); //
    }
    return Optional.empty(); //
}