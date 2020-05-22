Connection conn = null;
try {
    conn = ... // open connection
    doSomeWorkOnConnection(conn);
} finally {
    if (conn != null) {
        conn.close();
    }
}