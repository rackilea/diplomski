AccountHolder accountHolder = null;
    try {
        String verifyQuery = "SELECT * FROM accountholder WHERE username=? AND password=?)";
        connection = getConnection();
        ptmt = connection.prepareStatement(verifyQuery);

        ptmt.setString(1, username);
        ptmt.setString(2, password);

        ResultSet verified = ptmt.executeQuery();

        if (verified.next()) {
           accountHolder = new AccountHolder();
           accountHolder.setFirstName(rs.getString("FIRSTNAME"));
           accountHolder.setLastName(rs.getString("LASTNAME"));
           accountHolder.setUsername(rs.getString("USERNAME"));
           accountHolder.setPassword(rs.getString("PASSWORD"));
           accountHolder.setAddress(rs.getString("ADDRESS"));
           accountHolder.setPhoneNumber(rs.getString("PHONENUMBER"));

        }
    } catch (Exception ex) {
    } finally {
                connection.close();
    }
    return accountHolder ;
}