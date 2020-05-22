@Override
    public void fire(Connection conn, Object[] oldRow, Object[] newRow)
    throws SQLException {
        DSL.using(conn)
           .insertInto(LOG, LOG.FIELD1, LOG.FIELD2, ...)
           .values(LOG.FIELD1.getDataType().convert(newRow[0]), 
                   LOG.FIELD2.getDataType().convert(newRow[1]), ...)
           .execute();
    }