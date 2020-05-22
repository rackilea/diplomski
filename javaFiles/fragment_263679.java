String query = "insert into free(number) values (?)";
PreparedStatement ps = null;
try {
    ps = conn.prepareStatement(query);
    for (int number = 45000000; number < 46000000; number++) {
        ps.setInt(1, number);
        ps.addBatch();
        if ((number + 1) % 100 == 0) { // <-- this will add 100 rows at a time.
            ps.executeBatch();
        }
    }
    ps.executeBatch();
} catch (SQLException e) {
    e.printStackTrace();
} finally {
    if (ps != null) {
        try {
            ps.close();
        } catch (SQLException e) {
        }
    }
}