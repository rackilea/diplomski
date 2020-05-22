String sql = "select * from Table1 where xyz in :list"; 
// or String sql = "select * from Table1 where xyz in (:list)";
// I can't remember which one is right
Map parameters = new HashMap<String, Object>();
parameters.put("list", theListOfXyz);
List<Foo> result = template.query(sql, parameters, rowMapper);