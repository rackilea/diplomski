public String saveDetails() {
    try {
        int tempUserId = getUserid();
        String stringUserId = Integer.toString(tempUserId);
        String tempName = getName();
        String tempAddress = getAddress();
        String tempPhone = getPhone();
        String tempEmail = getEmail();

        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/TMA3C", "owner", "jsfdb");

        Statement stmt = con.createStatement();
        String query = "UPDATE APP.USERS SET FULLNAME = '" + tempName + "', ADDRESS = '" + tempAddress + "', PHONENUMBER = '" + tempPhone + "', "
                + "EMAIL = '" + tempEmail + "' WHERE USERID = " + stringUserId;
        System.out.println(query);
        stmt.executeUpdate(query);


    } catch (ClassNotFoundException ex) {
        Logger.getLogger(CustomBuild.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(CustomBuild.class.getName()).log(Level.SEVERE, null, ex);
    }

    return "mainPage";
}