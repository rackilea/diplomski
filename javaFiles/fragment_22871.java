public class CustomIdGenerator implements IdentifierGenerator {

private static final String QUERY_CALL_STORE_PROC = "call generateId(?,?,?)";

public Serializable generate(SessionImplementor session, Object object)
        throws HibernateException {

    Long result = null;
    try {
        Connection connection = session.connection();
        CallableStatement callableStmt = connection. prepareCall(QUERY_CALL_STORE_PROC);
        callableStmt.registerOutParameter(1, java.sql.Types.BIGINT);
        callableStmt.setInt(2, ((MyObject) object).getField1());
        callableStmt.setInt(3, ((MyObject) object).getField2());
        callableStmt.executeQuery();
      // get result from out parameter #1
        result = callableStmt.getLong(1);
        connection.close();
    } catch (SQLException sqlException) {
        throw new HibernateException(sqlException);
    }
    return result;
  }
}