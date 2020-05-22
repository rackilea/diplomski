String sql = "...";

Connection conn = play.db.DB.getConnection();
try {
    Statement stmt = conn.createStatement();
    try {
        stmt.execute(sql)
    } finally {
        stmt.close();
    }
} finally {
    conn.close();
}