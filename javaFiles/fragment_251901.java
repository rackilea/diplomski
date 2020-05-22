SQLQuery sqlQuery = session.createSQLQuery(sql);

// positional parameters (using ?)
sqlQuery.setString(0, sdate);
sqlQuery.setString(1, edate);
sqlQuery.setString(2, namc);

// scalar values for each column
sqlQuery.addScalar("UNLOAD", Hibernate.STRING);
sqlQuery.addScalar("ROUTE", Hibernate.STRING);
sqlQuery.addScalar("FREQUENCY ", Hibernate.INTEGER);

sqlQuery.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
List<Map<String, Object>> list = sqlQuery.list();

for (Map<String, Object> map : list) {
    System.out.println(map.get("UNLOAD"));
    System.out.println(map.get("ROUTE"));
    System.out.println(map.get("FREQUENCY"));
}