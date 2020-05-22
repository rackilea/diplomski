Connection con = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "1234");
        PreparedStatement st = con.prepareStatement("select 1 from register where password = ? and email = ? and name = ?");
        st.setString(1, password);
        st.setString(2, email);
        st.setString(3, name);

        ResultSet result = st.executeQuery();

        if (result.next()) { //.next() returns true if there is a next row returned by the query.
            return "Registered user";
        } else {
            return "Not registered";
        }


    } catch (Exception e) {
        //TODO manage the exception.
    } finally {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {}
        }
    }