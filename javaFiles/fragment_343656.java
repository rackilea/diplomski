public ResultSet runQuery(String sql) {
    SQLite connection = null;

    synchronized(this) {
        connection = connectionArray[currentIndex];
        currentIndex++;
        if (currentIndex >= connectionArray.length) {
            currentIndex = 0;
        }
    }

    return connection.query(sql);
}