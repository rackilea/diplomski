con = DriverManager.getConnection(...);
    String SQLQ = "SELECT * FROM TABLE( my_PKG.fnc_myList())";
    Statement st =con.createStatement();
    rs=st.executeQuery(SQLQ);
    while (rs.next()) {
        int id = rs.getInt(0);
        String name = rs.getString(1);
        ....
    }