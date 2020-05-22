public Connection dbConn() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(conString);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            System.out.println("Connection established, database uplink is online.");
        } else {
            System.out.println("Connection failed, please check database status.");
        }
      return conn;
    }