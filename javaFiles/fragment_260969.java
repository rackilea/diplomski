public void getDBContent(Connection conn) {
    final String str = "Select columnname,columnname2,columnname3 from tablename";
    try {
        PreparedStatement sqlStatement = conn.prepareStatement(str.toString());
        ResultSet rs = sqlStatement.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("columnname"));
            System.out.println(rs.getString("columnname2"));
            System.out.println(rs.getString("columnname3"));

        }
    } catch (Throwable e) {
    }
}