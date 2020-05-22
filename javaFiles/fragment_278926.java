Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   Connection con = DriverManager.getConnection("jdbc:odbc:DB");
   Statement st=con.createStatement();
   con.setAutoCommit(false); //Notice change here
   String name="roseindia";
   String address="delhi";
   int i=st.executeUpdate("insert into user(name,address)      values('"+name+"','"+address+"')");
   con.commit(); //Notice change here
   System.out.println("Row is added");
   con.close(); //Notice change here