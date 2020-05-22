SqlQuery query = Ebean.createSqlQuery("SELECT * FROM users WHERE username LIKE :username");
    query.setParameter("username", "%200ok%");

    List<SqlRow> rows = query.findList();

    for (SqlRow row : rows) {
        play.Logger.debug("Found user: " + row.getString("username") + " with ID: " + row.getInteger("id"));
    }