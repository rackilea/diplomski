public static ObjectA test1() {
  SqlRow row = Ebean.createSqlQuery("select * from table1").findUnique();

  return Optional.ofNullable(row)
                 .map(e -> new ObjectA(e.getInt("id"), e.getString("name")))
                 .orElse(ObjectA.EMPTY);
}