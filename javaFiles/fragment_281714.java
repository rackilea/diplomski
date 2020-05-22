public void close() {
    try {
        this.conn.close();
    } catch (Exception err) {
        System.out.println("Error while closing connection: " + err.getMessage());
    }
}