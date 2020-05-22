NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
String sql = "select * from emp where empno in (:ids)";
List idList = new ArrayList(2);
idList.add(new Long(7782));
idList.add(new Long(7788));
Map parameters = new HashMap();
parameters.put("ids", idList);
List emps = jdbcTemplate.query(sql, parameters, new EmpMapper());