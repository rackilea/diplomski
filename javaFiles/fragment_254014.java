String sql =  "SELECT NAME, YEAR, TYPE FROM CARS where NAME in (:cars)";
List<Cars> carsList = new ArrayList<Cars>();
NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
List<String> carNames = new ArrayList<String>();
for(Car car : carList){
    carNames.add(car.getName());
}
SqlParameterSource namedParameters = new MapSqlParameterSource("cars", carNames);
namedParameterJdbcTemplate.queryForObject(sql, namedParameters, ResponseType.class);