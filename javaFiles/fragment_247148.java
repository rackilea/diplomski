SqlQuery sqlQuery = Ebean.createSqlQuery("SELECT DISTINCT artist FROM musiclib");
List<SqlRow> rows = sqlQuery.findList();

for (SqlRow row : rows) {
    debug("I got one: " + row.getString("artist"));
}