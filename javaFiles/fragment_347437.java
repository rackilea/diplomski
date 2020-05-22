public class CallSPTest
{
   public static STRUCT createSTRUCT(oracle.sql.StructDescriptor structDescriptor, 
    java.sql.Connection connection, java.lang.Object[] objects) 
    throws java.sql.SQLException
    {
       return new STRUCT(structDescriptor,connection,objects);
    }
    public void testSP(Session s)
    {
       t = s.beginTransaction();
       s.doWork(new Work()
        {

            @Override
            public void execute(Connection connection) throws SQLException
            {
                try
                {
                    CallableStatement cs = connection.prepareCall("call SP_TEST(?)");                       
                    final Object[] values = new Object[]{1,2};

                    java.sql.Connection connect = 
  org.hibernate.jdbc.BorrowedConnectionProxy.getWrappedConnection(connection);
                    C3P0ProxyConnection castCon = (C3P0ProxyConnection) connect;
                    Method m = StructDescriptor.class.getMethod("createDescriptor", new Class[]{ String.class,Connection.class});
                    Object[] args = new Object[]{"MyType",C3P0ProxyConnection.RAW_CONNECTION};
                    StructDescriptor desc1 =(StructDescriptor) castCon.rawConnectionOperation(m, null, args);

                    Method m2 = CallSPTest.class.getMethod("createSTRUCT",
                            new Class[]{StructDescriptor.class, Connection.class,Object[].class});

                    args = new Object[] {desc1,C3P0ProxyConnection.RAW_CONNECTION,values};
                    final STRUCT struct1 = (STRUCT)castCon.rawConnectionOperation(m2,null,args);
                    cs.setObject(1, struct1, Types.STRUCT);
                    int aff_rows = cs.executeUpdate();
                }
                catch (Exception e)
                {
                    System.out.print(e.getMessage());
                }
            }
        });
    } 
    catch (Exception e)
    {
        System.out.print(e.getMessage());
    }
    finally
    {
        if (null != t)
        {
            t.rollback();                
        }
    }

}