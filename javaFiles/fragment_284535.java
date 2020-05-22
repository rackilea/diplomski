protected void registerArrayParameter(PreparedStatement st, int num, Long[] mas) throws SQLException {
    Connection conn = jdbcTemplate.getDataSource().getConnection();
    OracleConnection ocon = (OracleConnection) ((DelegatingConnection) conn).getInnermostDelegate();
    ArrayDescriptor arrayDescriptor = ArrayDescriptor.createDescriptor("CCSYS.NUMBER_TABLE", ocon);
    java.sql.Array sqlArray = new oracle.sql.ARRAY(arrayDescriptor, ocon, mas);
    st.setArray(num, sqlArray);

    /*added*/
    conn.close();
    ocon.close();
    SomeSource.dataSource.close();
}