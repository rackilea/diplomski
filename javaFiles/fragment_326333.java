public class MultiOutputItemWriter implements ItemWriter<List<Registration>> {
    ItemWriter<Registration> itemWriter;
    @Autowired
    NamedParameterJdbcTemplate namedParamJdbcTemplate;

     @Override
     public void write(List<? extends List<Registration>> items) throws Exception {
         for (List<Registration> registrations : items) {

         final String SQL_INSERT_INTO_REGISTRATION="INSERT INTO registration (employee_id, ....";

             final List<MapSqlParameterSource> params = new ArrayList<>();
             for (Registration registration : registrations) {
                 MapSqlParameterSource param = new MapSqlParameterSource();

                 param.addValue("employeeId", registration.getEmployeeId());
                 param.addValue("startDate", registration.getStartDate());
                 param.addValue("user", registration.getUser());
                 param.addValue("endTime", registration.getEndTime());

                 params.add(param);          

             }

             namedParamJdbcTemplate.batchUpdate(SQL_INSERT_INTO_REGISTRATION,params.toArray(new MapSqlParameterSource[params.size()]));
          }
    }
}