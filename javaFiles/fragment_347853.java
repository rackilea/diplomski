for ... {
    ...
    pstmt.clearParameters();
    pstmt.setString(1, name);
    pstmt.setInt(2 id);
    pstmt.setTimeStamp(3, new java.sql.Timestamp(dt.getTime()));
    pstmt.addBatch();
}
pstmt.executeBatch();