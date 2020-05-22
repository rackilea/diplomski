public static void insertIntoOrderTable(BasicDataSource basicDataSource, String plantname) throws  SQLException{
    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        conn = basicDataSource.getConnection();
        stmt = conn.prepareStatement(Util.readFileFromClasspath("insert_plant.sql"), new String[]{"id"});
        stmt.setString(1, plantname);
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()){
            System.out.println(rs.getLong(1));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}