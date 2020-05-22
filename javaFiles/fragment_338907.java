private static final String FIND_BY_PK_SQL 
                 = "SELECT mail, name, password, admin FROM user WHERE mail = ?";

public User findByPk(final String mail) throws DAOException {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
        conn = getConnection();
        ps = conn.prepareStatement(FIND_BY_PK_SQL);
        ps.setString(1, mail); // PK, NOT NULL
        rs = ps.executeQuery();
        if (rs.next()) {
            return fill(rs);
        }
        return null;
    } catch (final SQLException e) {
        throw new DAOException(e);
    } finally {
        // Close DB resources
    }
}

private User fill(final ResultSet rs) throws SQLException {
    final User user = new User();
    user.setMail(rs.getString("mail"));
    user.setName(rs.getString("name"));
    user.setPassword(rs.getString("password"));
    user.setAdmin(rs.getBoolean("admin"));
    return user;
}