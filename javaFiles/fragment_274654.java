package test;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Arrays;

public class OracleTest {

  public static void main(String[] args) {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection conn = DriverManager.getConnection(
              "<your JDBC url>", "<your user>", "<your password>");

      // Prepare the call, without defining the the output variable
      // in a DECLARE section of the PL/SQL itself, you just need to
      // include a "?" and then associate the correct type in the
      // next step.
      CallableStatement cs = conn.prepareCall(
                "BEGIN\n"
              + "  UPDATE emp\n"
              + "     SET job = job\n"
              + "   WHERE comm is not null\n"
              + "  RETURNING empno BULK COLLECT INTO ?;\n"
              + "END;");

      // Register the single OUT parameter as an array, using the 
      // type that was defined in the database, T_INTEGER_ARRAY.
      cs.registerOutParameter(1, Types.ARRAY, "T_INTEGER_ARRAY");
      cs.execute();

      // Now get the array back, as array of BigDecimal.
      // BigDecimal is used because it doesn't have precision 
      // problems like floating point, it will contain all digits
      // that the database provided.
      BigDecimal[] nums = (BigDecimal[]) (cs.getArray(1).getArray());
      System.out.println(Arrays.toString(nums));
      cs.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}