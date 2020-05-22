// use placeholders in the query (marked with ? sign)
QUERY = "INSERT INTO messaggio(Nickname,DataConnesione,DataMessaggio,messaggio) VALUES (?,?,?,?);";
ps = conn.prepareStatement(QUERY);
// now bind the variables
ps.setString(1, username);
ps.setString(2, dateConnections);
ps.setString(3, time);
ps.setString(4, message);
// and only now execute the query
ps.executeUpdate();