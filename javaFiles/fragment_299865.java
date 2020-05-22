String query = "SELECT count(*) FROM users ;"; 

    rs.next();     

    ResultSet rs = stmt.executeQuery(query);

    int count = Integer.parseInt(rs.getString("count(*)"));