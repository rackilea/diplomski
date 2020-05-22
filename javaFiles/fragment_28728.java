public List<CSPData> getCSPData() throws SQLException {
    List<CSPData> result = new ArrayList<>();
    try {
        String drivername = "org.apache.hive.jdbc.HiveDriver";
        Class.forName(drivername);
        connection = DriverManager.getConnection("jdbc:hive2://hddev-c01-edge-01:20000/");
        statement = connection.createStatement();
        resultset = statement.executeQuery(
                "select distinct db_name as db_name,db_server_name as db_server_name,lower(db_name) as l_db_name,lower(db_server_name) as l_server_name,regexp_replace(lower(db_server_name), '-', '_') as server_name,db_server_name_secondary as db_server_name_secondary from csp.curated_input");

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.exit(1);
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println(e.getMessage());
    }


    while (resultset.next()) {
        CSPData cspdata = new CSPData ();
        cspdata.setDbName(resultset.getString("db_name"));
        cspdata.setDbServerName(resultset.getString("db_server_name"));
        cspdata.setDbServerNameSecondary(resultset.getString("db_server_name_secondary"));
        cspdata.setlDbName(resultset.getString("l_db_name"));
        cspdata.setlServerName(resultset.getString("l_server_name"));
        cspdata.setServerName(resultset.getString("server_name"));
        result.add(cspdata);
    }

    return result;
}