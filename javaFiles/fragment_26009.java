public class TestV6R1 {

   public static void main( String[] args ) {
      Connection conn = null;
      PreparedStatement ps1 = null;
      PreparedStatement ps2 = null;
      try {
         conn = getNewConnection();
         conn.setAutoCommit( false );

         String value = "Test: " + new Timestamp( System.currentTimeMillis() );

         // First statement which uses RETURN_GENERATED_KEYS
         ps1 = conn.prepareStatement( "insert into test_v6r1 (id, value ) values (?, ?)", Statement.RETURN_GENERATED_KEYS );
         ps1.setInt( 1, 1 );
         ps1.setString( 2, value );
         int ps1Rows = ps1.executeUpdate();
         // in case of V5R4
         // ps1Rows is 1
         // in case of V6R1
         // ps1Rows is 0

         ResultSet ps1keys = ps1.getGeneratedKeys();
         int ps1KeySize = 0;
         if (ps1keys != null) {
            ps1keys.last();
            ps1KeySize = ps1keys.getRow();
         }
         System.out.println("PS1 - SQL insert affected " + ps1Rows + " rows and returned " + ps1KeySize + " keys");
         System.out.println("PS1 - getUpdateCount()="+ ps1.getUpdateCount());

         // Second statement which uses NO_GENERATED_KEYS
         ps2 = conn.prepareStatement( "insert into test_v6r1 (id, value) values (?, ?)", Statement.NO_GENERATED_KEYS );
         ps2.setInt( 1, 2 );
         ps2.setString( 2, value );
         int ps2Rows = ps2.executeUpdate();
         // in case of V5R4
         // ps2Rows is 1
         // in case of V6R1
         // ps2Rows is 1

         ResultSet ps2Keys = ps2.getGeneratedKeys();
         int ps2KeySize = 0;
         if (ps2Keys != null) {
            ps2Keys.last();
            ps2KeySize = ps2Keys.getRow();
         }

         System.out.println("PS2 - SQL insert affected " + ps2Rows + " rows and returned " + ps2KeySize + " keys");
         System.out.println("PS2 - getUpdateCount()="+ ps2.getUpdateCount());

         conn.commit();
      }
      catch ( Throwable e ) {

         e.printStackTrace();
         try {
            conn.rollback();
         }
         catch ( SQLException e1 ) {
            e1.printStackTrace();
         }
      }
      finally {
         try {
            if (ps1!=null) ps1.close();
            if (ps2!=null) ps2.close();
            if (conn!=null) conn.close();
         }
         catch ( SQLException e ) {
            e.printStackTrace();
         }
      }

   }

   public static Connection getNewConnection() {
      try {
         Class.forName( "com.ibm.as400.access.AS400JDBCDriver" ); // Or any other driver
      }
      catch ( Exception x ) {
         System.out.println( "Unable to load the driver class!" );
      }
      Connection dbConnection = null;
      try {
         // TEST - V6R1
         dbConnection = DriverManager
               .getConnection( "jdbc:as400://testServer;libraries=*libl;naming=system;sort=language;sort language=HRV;sort weight=shared;prompt=false;trace=true",
                               "username",
                               "password" );
         // PRODUCTION - V5R4
//         dbConnection = DriverManager
//         .getConnection( "jdbc:as400://productionServer;libraries=*libl;naming=system;sort=language;sort language=HRV;sort weight=shared;prompt=false;trace=true",
//                         "username",
//                         "password" );

      }
      catch ( SQLException x ) {
         System.out.println( "Couldn’t get connection!" );
      }

      return dbConnection;
   }

}