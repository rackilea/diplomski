public static ObjectA test1() {
  SqlRow row = Ebean.createSqlQuery("select * from table1").findUnique();

  return row == null ? ObjectA.EMPTY
                     : new ObjectA(row.getInt("id"), row.getString("name"));
}