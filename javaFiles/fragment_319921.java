Context initContext = new InitialContext();
     Context envContext = (Context) initContext.lookup("java:/comp/env");
     DataSource dataSource = (DataSource) envContext.lookup("jdbc_northwind");
     try (Connection conn = dataSource.getConnection(); 
           Statement s = conn.createStatement();
           ResultSet rs = s.executeQuery("select * from customers")) {
           while (rs.next()) {
                out.print(rs.getString("CompanyName"));
                out.print("<br>");
           }         
       }