// ...
final byte[] bytes= IOUtils.toByteArray(input);

final OracleLobHandler lobHandler = new OracleLobHandler();
final lobHandler.setNativeJdbcExtractor(new JBossNativeJdbcExtractor());
// ...
new CallableStatementCreator() {

    public CallableStatement createCallableStatement(Connection con)
            throws SQLException {
         String procedure = "call SAVE_DATA(?,?)";

            CallableStatement stm=con.prepareCall(procedure);

            lobHandler.getLobCreator().setLobAsBytes(smt, 1, bytes, bytes.length);
            stm.setDate(2, date);
        return stm;
    }
}
// ...