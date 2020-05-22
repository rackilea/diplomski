public void callablestatement(Connection conn, int resync_value) {
    String qry = "{call resync_entity.resync_this_entity(?)}";
    try (CallableStatement stmt = conn.prepareCall(qry)) {
        stmt.setInt(1, resync_value);
        stmt.execute();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}