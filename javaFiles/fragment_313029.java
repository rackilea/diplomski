try (Connection conn = DriverManager.getConnection(myConnectionString, "root", "beer")) {
    try (Statement st = conn.createStatement()) {
        st.execute(
                "CREATE TEMPORARY TABLE dummy (" +
                    "`id` INT AUTO_INCREMENT PRIMARY KEY, " +
                    "`NAME` VARCHAR(50), " +
                    "`size` INT, " +
                    "`create_date` DATETIME " +
                ")");
    }
    conn.setAutoCommit(false);
    System.out.println("AutoCommit is OFF.");
    String sql = "INSERT INTO dummy(NAME, `size`, create_date) VALUES('test', ?, NOW())";
    try (PreparedStatement ps = conn.prepareStatement(
            sql, 
            PreparedStatement.RETURN_GENERATED_KEYS)) {
        // first batch
        ps.setInt(1, 1);  // `size` = 1
        ps.addBatch();
        ps.setInt(1, 2);  // `size` = 2
        ps.addBatch();
        ps.executeBatch();
        System.out.println("First batch executed. The following AUTO_INCREMENT values were created:");
        try (ResultSet rs = ps.getGeneratedKeys()) {
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        }
        try (Statement st = conn.createStatement()) {
            sql = "SELECT COUNT(*) AS n FROM dummy";
            try (ResultSet rs = st.executeQuery(sql)) {
                rs.next();
                System.out.println(String.format("The table contains %d row(s).", rs.getInt(1)));
            }
        }
        conn.rollback();
        System.out.print("Transaction rolled back. ");
        try (Statement st = conn.createStatement()) {
            sql = "SELECT COUNT(*) AS n FROM dummy";
            try (ResultSet rs = st.executeQuery(sql)) {
                rs.next();
                System.out.println(String.format("The table contains %d row(s).", rs.getInt(1)));
            }
        }
        // second batch
        ps.setInt(1, 97);  // `size` = 97
        ps.addBatch();
        ps.setInt(1, 98);  // `size` = 98
        ps.addBatch();
        ps.setInt(1, 99);  // `size` = 99
        ps.addBatch();
        ps.executeBatch();
        System.out.println("Second batch executed. The following AUTO_INCREMENT values were created:");
        try (ResultSet rs = ps.getGeneratedKeys()) {
            while (rs.next()) {
                System.out.println(rs.getInt(1));
            }
        }
    }
    try (Statement st = conn.createStatement()) {
        sql = "SELECT COUNT(*) AS n FROM dummy";
        try (ResultSet rs = st.executeQuery(sql)) {
            rs.next();
            System.out.println(String.format("The table contains %d row(s).", rs.getInt(1)));
        }
    }
}