// NB: no databaseName specified in the following
String connectionUrl = "jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;integratedSecurity=true";  

try (Connection conn = DriverManager.getConnection(connectionUrl)) {
    String sql = "SELECT name FROM sys.master_files WHERE type_desc='ROWS' ORDER BY database_id";
    try (
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql)) {
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
    }
} catch (Exception e) {
    e.printStackTrace(System.err);
}