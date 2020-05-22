public ArrayList<Map<String, String>> getListOfMapsFromSQL(String sql) throws SQLException {
    con = DriverManager.getConnection(url,user,pass);
    stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();

    rs = stmt.executeQuery(sql);
    ResultSetMetaData rsmd = rs.getMetaData();

    while(rs.next()){
        Map<String, String> fieldsMap = new HashMap<String, String>();
        for(int i=1; i<=rsmd.getColumnCount(); i++){
            fieldsMap.put(rsmd.getColumnLabel(i), rs.getObject(i).toString());
        }
        list.add(fieldsMap);
    }

    list.trimToSize();
    stmt.close();
    con.close();
    return list;
}