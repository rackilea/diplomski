....
try {

        String sql1 = "select * from products where name like '"+searchTerm+"';";
        DBConnection db = new DBConnection();
        Connection con = db.getConnection();

        Statement ps = con.createStatement();

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

....