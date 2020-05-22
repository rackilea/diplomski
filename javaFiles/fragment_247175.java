connection = dataSource.getConnection();
        ResultSet rs;
        connection.setAutoCommit(false);
        System.out.println("Connected to server OELDBSQL!!!");
        Statement stmt=connection.createStatement();
        String querystring="select loc from location";
        rs = stmt.executeQuery(querystring );
        while(rs.next())  {
        Element child1 = doc.createElement("company");
        child1.setAttributeNS(comp,"comp:loc", rs.getString (1));