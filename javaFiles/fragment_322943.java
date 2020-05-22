public class DB {
    public static String executeProc(Connection conn, MyObject01 obj)
        throws SQLException
    {
        CalllableStatement cs = conn.prepareCall(" { ? = call sch.proc(?) }");
        cs.registerOutParameter(1, Types.VARCHAR);
        obj.setupArrays((oracle.jdbc.Connection)conn);
        cs.setObject(2, obj, Types.STRUCT);
        cs.executeUpdate();
        String ret = cs.getString(1);
        cs.close();
        return ret;
    }
}