String sql = 
    "INSERT INTO table1 (ip, protocol, counter, timer)"
    + " SELECT ip,protocol,counter,?"
    + " FROM table2"
    + " ORDER BY counter DESC"
    + " LIMIT 5 OFFSET 0";