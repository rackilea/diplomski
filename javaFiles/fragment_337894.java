Connection connection = null;
        Statement statement = null;
        try {
            String sql = "INSERT INTO testTable(name) VALUES('Anonym')";
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
            long lastInsertedID = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs= statement.getGeneratedKeys();
            if (rs.next()) 
            {
              System.out.println("Last Inserted ID = "+rs.getLong(1));
            }    

        } catch (Exception e) {
            e.printStackTrace();
        }