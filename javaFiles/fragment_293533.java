public String addQuery2(String fname, String lname, String gender, String date) throws Exception {
    String getMe = null;
    ResultSet res = null;
    try {
        Connection con;
        PreparedStatement pStatement;
        String query = "insert into UserTable(FirstName,LastName,Gender,Date) " +
                "values ( '" + fname + "' , '" + lname + "' , '" + gender + "', '" + date + "' ) ";
        con = DriverManager.getConnection(...);
        pStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pStatement.execute(query)
        res = pStatement.getGeneratedKeys();
            getMe = String.valueOf(res.getInt(1));

    } catch (SQLException sqle) {
        sqle.printStackTrace();
    }
    return getMe;
}