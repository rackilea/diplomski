public void close() throws SQLException {
    if (this.connection is still eligible for reuse) {
        do not close this.connection, but just return it to pool for reuse;
    } else {
        actually invoke this.connection.close();
    }
}