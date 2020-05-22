try { // load driver
    Class.forName(properties.getStringProperty("dbDriver")).newInstance();
    connection = DriverManager.getConnection(url, user, passwort);
} catch (SQLException ex) {
    Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
}