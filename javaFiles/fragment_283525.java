private synchronized ConnectionPool pCreatePool() throws SQLException {
    if (pool != null) {
        return pool;
    } else {
        pool = new ConnectionPool(poolProperties);
        return pool;
    }
}