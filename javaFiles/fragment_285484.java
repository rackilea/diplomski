ArrayList<String> objectsToStore = new ArrayList<>();
    Random rnd = new Random();

    for (int i = 1; i <= 5; i++) {
        objectsToStore.add("username" + rnd.nextInt() + "@gmail.com");
    }

    try {
        //1) this used to load mysql jdbc driver into memory
        Class.forName("com.mysql.jdbc.Driver");
        //2) create connection to running mysql instance
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbName?useSSL=false", "username", "password");
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        for (String x : objectsToStore) {
            // this insert will work assuming you have table user_data with email field
            statement.executeUpdate("INSERT INTO USER_DATA (email) VALUES ('" + x +"')");
        }
        //commit transaction
        connection.commit();
        statement.close();
        connection.close();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }