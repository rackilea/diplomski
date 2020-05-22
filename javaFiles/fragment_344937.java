for(int i = 0; i < dbNames.size(); i++) {
    //here I am setting the dbname in connection obj
    conn.setCatalog(dbNames.get(i));
    //then I am creating a new Statement
    stmt = conn.createStatement();

    sql = "SHOW TABLES";
    rs = stmt.executeQuery(sql);
    while(rs.next()) {
        System.out.println(rs.getString(1) 
           + " is a table in " + dbNames.get(i) + " database.");
    }
}