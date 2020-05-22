Connection conn;
       Statement st; 
       ResultSet rs;
       String dbURL="jdbc:odbc:oracle:thin:@localhost:1521:XE";
       String userId="system";
       String pwd="moon";
       try {
           Class.forName("oracle.jdbc.OracleDriver");
           conn=DriverManager.getConnection(dbURL,userId,pwd);
           st=conn.createStatement();
           rs= st.executeQuery("SELECT * FROM login"); 
           while(rs.next()) {
               System.out.println(rs.getString(1)+" "+rs.getString(2));
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           DatabaseUtils.close(rs);  // implement static methods to do this.
           DatabaseUtils.close(st);
           DatabaseUtils.close(conn);
       }