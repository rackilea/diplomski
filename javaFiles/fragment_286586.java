try {
    Class.forName(database.getJDBC_DRIVER());
    cnn = DriverManager.getConnection(database.getDB_URL());
    p = cnn.prepareStatement(query);
    rs = p.executeQuery();
} catch (SQLException e) {
    e.printStackTrace();
} catch (ClassNotFoundException e) {
    e.printStackTrace();
} finally {
    try {
        if (rs != null) { 
            rs.close();
        }
        if (p != null) { 
            p.close();
        }
        if (cnn != null) { 
            cnn.close();
        }
    } catch (SQLException e) {
        System.err.println("Can't close an object, not much I can do");
    }
}