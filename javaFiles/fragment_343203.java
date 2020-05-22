public String getIngredientByName(@QueryParam("name") String theName)
        throws SQLException, ClassNotFoundException {
    //Obtaining an ingredient from the database
    String connectStr = "jdbc:mysql://localhost:3306/fooddb";
    String username = "root";
    String password = "csci330pass";
    String driver = "com.mysql.jdbc.Driver";
    Class.forName(driver);
    String result = "";
    try (Connection con = DriverManager.getConnection(connectStr, username, password)) {
        try (PreparedStatement stmt = con.prepareStatement("SELECT id, name, category FROM ingredient WHERE name =?")) {
            stmt.setString(1, theName);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int theId3 = rs.getInt("id");
                    String theName3 = rs.getString("name");
                    String theCategory = rs.getString("category");
                    result += "id: " + theId3 + " , name: " + theName3 + "(" + theCategory + ")" + "\n" + "\n";
                }
            }
        }
    }
    return result;
}//END METHOD