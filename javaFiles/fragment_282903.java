public class MyTrigger implements Trigger {

    @Override
    public void init(Connection conn, String schemaName, 
                     String triggerName, String tableName, boolean before, int type)
    throws SQLException {}

    @Override
    public void fire(Connection conn, Object[] oldRow, Object[] newRow)
    throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO log (field1, field2, ...) " +
            "VALUES (?, ?, ...)")
        ) {
            stmt.setObject(1, newRow[0]);
            stmt.setObject(2, newRow[1]);
            ...

            stmt.executeUpdate();
        }
    }

    @Override
    public void close() throws SQLException {}

    @Override
    public void remove() throws SQLException {}
}