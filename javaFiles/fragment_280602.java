private User convertRowToUser(ResultSet rs) throws SQLException {
    int resultInt = rs.getInt(1);
    String lastName = rs.getString(2);
    System.out.println(resultInt + "\t" + lastName);
    User tempUsers = new User(lastName, resultInt);
    return tempUsers;
}