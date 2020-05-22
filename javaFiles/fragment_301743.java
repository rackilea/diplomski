String sql = "{call xxx(?,?)}";
try (CallableStatement stmt = conn.prepareCall(sql)) {
    stmt.registerOutParameter(1, TYPES.INTEGER);
    stmt.registerOutParameter(2, TYPES.VARCHAR);
    stmt.execute();
    result = stmt.getInt(1);
    err = stmt.getString(2);
}