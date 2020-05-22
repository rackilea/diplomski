@Resource(name = "myJdbcTemplate")
public JdbcTemplate simpleJdbc;

private Connection getConnection() throws SQLException{
    return simpleJdbc.getDataSource().getConnection();
}

    @Override
    public boolean setProfessionalBD(Professional professional,
    Category category, BigDecimal id_language, BigDecimal id_institution)
            throws SQLException {

    CallableStatement proc_strm = null;

    proc_strm = getConnection().prepareCall(
            "BEGIN ? := "
                    + "     CASE PK_BACKOFFICE.SET_PROFESSIONAL"
                    + "         (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,TRUE,?,?)"
                    + "     WHEN true " + "     THEN 1 " + "        ELSE 0 "
                    + "     END; " + "  END;");

    proc_strm.registerOutParameter(1, Types.INTEGER);
    proc_strm.setBigDecimal(2, id_language);
    proc_strm.setBigDecimal(3, id_institution);
    (...)
    proc_strm.execute();