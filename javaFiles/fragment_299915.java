public void open() {
        try {
            String databaseName = "custom";
            String userName = "root";
            String password = "welcome";

            // 
            String url = "jdbc:mysql://localhost/" + databaseName;

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            System.out.println("Not able to connect");
        }
    }