public synchronized ResultSet query(String query) throws SQLException {
    //Statement never closed
    return connection.prepareStatement(query).executeQuery();
}

public synchronized boolean update(String query) throws SQLException {
    //Statement never closed
    return connection.prepareStatement(query).execute();
}