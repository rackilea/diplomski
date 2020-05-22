void migrate() throws SQLException {
        Connection connA = DriverManager.getConnection("jdbc:oracle:thin:@myhost:1521:orcl");
        Connection connB = DriverManager.getConnection("jdbc:mysql://192.168.1.33/test");

        PreparedStatement stmA = connA.prepareStatement("select * from product where 1=1");
        PreparedStatement stmB = connB.prepareStatement("insert into prod values(?,?,?,?)");

        ResultSet rs = stmA.executeQuery();
        while (rs.next()) {
            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                stmB.setObject(i + 1, rs.getObject(i + 1));
            }
            stmB.executeUpdate();
        }

        connA.close();
        connB.close();
    }