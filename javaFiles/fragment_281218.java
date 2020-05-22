String[] query = { "insert into Gericht (classification,date,name,preisExtern,preisIntern) values (?,?,?,?,?)",
            "test" };
    PreparedStatement stmt;
    for (String str : query) {
        stmt = c.prepareStatement(str);
        stmt.addBatch();
    }
    stmt.executeBatch();