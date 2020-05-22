public static String sqlSelect(String id) throws SQLException {
    try(Connection con = dataSource().getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT row FROM table WHERE key = ?")) {
          ps.setString(1, id);
          try(ResultSet resultSet = ps.executeQuery()) {
            if(rs.next()) {
              return rs.getString(1);
            } else {
              throw new SQLException("Nothing found");
            }
          }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
}