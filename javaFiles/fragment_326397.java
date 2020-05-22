class A {
    public static DataSource getConnection() {
     Context initContext  = new InitialContext();
     Context envContext  = (Context)initContext.lookup("java:/comp/env");
     DataSource dataSource = (DataSource)envContext.lookup("jdbc/testdb");
     return dataSource;
    }
     }  
   class B {
    javax.sql.DataSource ds=(DataSource)A.getConnection();
    javax.sql.Connection con=ds.getConnection();
    }