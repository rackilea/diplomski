protected String expDelete = "DELETE FROM TABLE1 WHERE ID = :id AND CREATION_DATE IS NULL";
protected String dipDelete = "DELETE FROM TABLE2 WHERE ID = :id AND CREATION_DATE IS NULL";

Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("id", employeeInTreatment.getId());

new NamedParameterJdbcTemplate(this.dataSource).update(expDelete,parameters);
new NamedParameterJdbcTemplate(this.dataSource).update(dipDelete,parameters);