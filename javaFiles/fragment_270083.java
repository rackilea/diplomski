return sparkSession
    .read()
    .format("org.apache.spark.sql.cassandra")
    .options(new HashMap<String, String>() {
        {
            put("keyspace", "chat");
            put("table", "user");
        }
    })
    .load()
    .select("first_name", "last_name", "email")
    .filter("user_id = '" + userid +"'")
    .toJSON()
    .first();
}