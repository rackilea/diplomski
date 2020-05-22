try {
    ResultSet rs = Core.getSQL().getResultSet("SELECT * FROM nicks");

    rs.next();
    names = rs.getString("nicknames");
}