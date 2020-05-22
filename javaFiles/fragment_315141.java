String sql =
    "CREATE TABLE table1"
    + " SELECT ip,protocol,counter,?"
    + " FROM table2"
    + " ORDER BY counter DESC"
    + " LIMIT 5 OFFSET 0";