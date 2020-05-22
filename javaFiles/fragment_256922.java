public class ScheduledClassesDAO {
    private DataSource dataSource;
    private JdbcTemplate jt;
    private SimpleJdbcCall sjc;

    public void setDataSource(DataSource dataSource){
        this.jt = new JdbcTemplate(dataSource);
        jt.setResultsMapCaseInsensitive(true);
        sjc = new SimpleJdbcCall(jt)
                .withCatalogName("upclsch")
                .withProcedureName("p_get_class_schedule");
    }

    /**
     * This method is used to return scheduled classes by calling a stored-proc.
     * @param termCode   String: The term/semester for this lookup.
     * @param netId      String: The netId of the student to lookup
     * @return           Map<String, Object>
     */
    public Map<String, Object> execute(String termCode, String netId){

        sjc.useInParameterNames("p_term", "p_scauid", "p_pidm")
            .withoutProcedureColumnMetaDataAccess()
            .declareParameters(new SqlOutParameter("p_classsched_ref_out", OracleTypes.CURSOR),
                    new SqlParameter("p_term", OracleTypes.VARCHAR),
                    new SqlParameter("p_scauid", OracleTypes.VARCHAR),
                    new SqlParameter("p_pidm", OracleTypes.NUMBER));

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_pidm", null)
                .addValue("p_scauid", netId)
                .addValue("p_term", termCode);


        Map<String, Object> results = sjc.execute(in);

        return results;
    }
}