try (Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Michel's Muziek Magazijn.accdb")) {
    try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM mmm WHERE ? = ?")) {
        try (ResultSet rs = stmt.executeQuery()) {
            //...
        }
    }
} catch (SQLException e) {
    e.printStackTrace();
}