import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleDataSource;

public final class DBTest
{
    public static void main(String[] args)
    throws SQLException
    {
        OracleDataSource datasource;
        Connection conn = null;
        CallableStatement cStmt = null;
        ResultSet rSet = null;

        try
        {
            datasource = new OracleDataSource();
            String jdbcURL = "jdbc:oracle:thin:*/*@*:1521:*";
            datasource.setURL(jdbcURL);
            conn = datasource.getConnection();
            cStmt = conn.prepareCall("{ call get_user(?) }");
            cStmt.registerOutParameter(1, OracleTypes.CURSOR);
            cStmt.execute();
            rSet = (ResultSet) cStmt.getObject(1);
            while (rSet.next())
            {
                System.out.println(rSet.getInt(1)
                    + ":" + rSet.getInt(2)
                    + ":" + rSet.getString(3)
                    + ":" + rSet.getString(4));
            }
        }
        finally
        {
            if (rSet != null)
            {
                rSet.close();
            }
            if (cStmt != null)
            {
                cStmt.close();
            }
            if (conn != null)
            {
                conn.close();
            }
        }
    }
}