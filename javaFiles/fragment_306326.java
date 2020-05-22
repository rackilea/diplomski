emf.close();
    try {
        Backup.execute("./backup/name.zip", "./data", "mydb", true);
        System.out.println("done");
    } catch (SQLException e) {
        e.printStackTrace();
    }