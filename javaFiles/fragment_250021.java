public void foo() {
    try (Connection conn = datasource.getConnection()) {
        try {
            bar(conn, "arg");
            conn.commit();
        } catch (Exception ex) {
            conn.rollback();
            throw ex;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}