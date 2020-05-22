try (Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/abpp034?user=abpp034&password=120001772")){        
    try (PreparedStatement stmt = con.prepareStatement("SELECT Name FROM Discount WHERE Type = \"" + type + "\"")) {
        try (ResultSet rs = stmt.executeQuery) {
            //...
        } catch (SQLException exp) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    } catch (SQLException exp) {
        Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
    }
} catch (SQLException ex) {
    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
}