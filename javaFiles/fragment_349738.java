List<Object[]> li = new ArrayList<Object[]>();
for(T t : list) { li.add(toObjectArr(t)); } //toObject converts my Pojo to Object[]

JdbcTemplate template = (JdbcTemplate)getJdbcTemplate().getJdbcOperations();
//paramconverter is a pre-compiled regex that matches :\w*
String insert = paramConverter.matcher(getInsertQuery()).replaceAll("?");

template.batchUpdate(insert, li);