import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;   
.....
public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException
{
 //null check?

   ArrayDescriptor desc = ArrayDescriptor.createDescriptor("STRARRAY ", ps.getConnection());
   ARRAY oracleArray = new ARRAY(desc, ps.getConnection(), parameter);
   ps.setArray(i, oracleArray);
}