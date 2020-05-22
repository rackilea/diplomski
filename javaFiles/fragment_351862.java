public boolean isLoginFree(String login) {
    boolean ans = false;
    try(PreparedStatement pst = con.prepareStatement("select login " +
                                                     "from User " +
                                                     "where login = ?")) {
        pst.setString(1, login);
        try(ResultSet rs = pst.executeQuery()) {
            ans = !rs.first();
        } catch(SQLException e) {
            // Handle the exeption for the result set
        }
    } catch(SQLException e) {
        // Handle the exeption for the prepared statement
    }
    return ans;
}