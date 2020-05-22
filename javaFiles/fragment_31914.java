String connStr = "jdbc:ucanaccess://C:/Users/Public/mdbTest.mdb";
try (Connection conn = DriverManager.getConnection(connStr)) {
    try (Statement s = conn.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {       
        ResultSet rs = s.executeQuery("SELECT Id, Field1, Field2 FROM ucatest");
        rs.moveToInsertRow();
        rs.updateInt("Id", 0);
        rs.updateString("Field1", "newvalue1");
        rs.updateString("Field2", "newvalue2");
        rs.insertRow();
    }
}