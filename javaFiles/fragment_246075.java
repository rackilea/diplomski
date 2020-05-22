import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleCallableStatement;

public class TestDatabaseArray
{
  public static void main( final String[] args )
  {
    try{
      Class.forName( "oracle.jdbc.OracleDriver" );

      Connection con = DriverManager.getConnection(
          "jdbc:oracle:thin:@localhost:1521:orcl",
          "username",
          "password"
        );

      OracleCallableStatement st
        =(OracleCallableStatement) con.prepareCall("{ call get_names( :out_array ) }");

      st.registerOutParameter( 1, java.sql.Types.ARRAY, "NAMELIST" );

      st.execute();

      String[] names = (String[]) st.getARRAY( 1 ).getArray();

      for ( final String name : names )
        System.out.println( name );
    }
    catch ( ClassNotFoundException | SQLException ex )
    {
      System.out.println( ex.getMessage() );
      ex.printStackTrace();
    }
  }
}