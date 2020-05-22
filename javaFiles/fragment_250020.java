public void foo() {
    try (Connection conn = datasource.getConnection()) {
        bar(conn, "arg");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void bar(Connection conn, String args) throws SQLException {
    try (PreparedStatement ps = conn.prepareStatement("SOME_QUERY")) {
        // Do something
        ps.executeUpdate();
        conn.commit();
    } catch (SQLException err) {
        conn.rollback();
        throw err;
    }
}