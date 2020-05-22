@Override
public User findByUserName(String username, Connection conn) throws SQLException {
    PreparedStatement st = null;
    ResultSet rs =null;
    try {
        st = conn.prepareStatement("SELECT * FROM userdetails where User_Name = ?");
        st.setString(1, username);
        rs = st.executeQuery();
        User user = new User();
        user.setUserName(rs.getString("User_Name"));
        user.setFirstName(rs.getString("First_Name"));
        user.setLastName(rs.getString("Last_Name"));
        user.setEmailAddress(rs.getString("Email_Address"));
        user.setType(rs.getString("Type"));
        user.setPassword(rs.getString("password"));
        return user;
    }catch(SQLException e) {
        throw e;
    }
}