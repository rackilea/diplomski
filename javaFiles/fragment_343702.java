@Override
public Number add(UserName userName) {
    KeyHolder holder = new GeneratedKeyHolder();
    this.jdbcTemplate.update(
        new PreparedStatementCreator() {
          public PreparedStatement createPreparedStatement(Connection connection)
                                                            throws SQLException {
            PreparedStatement pstmt = connection.prepareStatement(
                                      INSERT_USERNAME, new String[] {"UserNameId"});
            pstmt.setString(1, userName.getUserName());
            pstmt.setString(2, userName.getPassword());
            pstmt.setInt(3, userName.getRole().getRoleId());
            pstmt.setBoolean(4, userName.isEnabled());
            return pstmt;
          }
        }, holder);
    Number key = holder.getKey();
    userName.setUserNameId(key.intValue());
    return key;
}