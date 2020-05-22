try{
    Connection conn = DriverManager.getConnection(connectionURL, userName, userPassword);

    if (conn != null){
        List<User> users = userRepo.read(conn);

        System.out.println("How many users loaded: " + users.size()); 
        printArray(users);
        conn.close();
    }