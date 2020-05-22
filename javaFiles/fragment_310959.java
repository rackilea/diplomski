try {
        DataSource dataSource = null;// specify data source
        Connection con = dataSource.getConnection();
        Statement s = con.createStatement();
        // or
        // PreparedStatement s =
        // con.prepareStatement("INSERT INTO profile (fullname) VALUES ('Visruth CV')");
        s.addBatch("INSERT INTO tran1 (username, password, profileid) VALUES ('visruth', 'password', 1)");
        s.addBatch("INSERT INTO testtab (name) VALUES ('testtab')");
        s.executeBatch();

    } catch (SQLException e) {
        e.printStackTrace();
    }