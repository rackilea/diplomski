public class AccountInformationToDatabase {


private BasicDataSource dataSource;
public BasicDataSource getDataSource() {
    return dataSource;
}
public void setDataSource(BasicDataSource dataSource) {
    this.dataSource = dataSource;
}
@Handler
public void PersistRecord
(
        @Body AccountRecordBindy msgBody
        , @Headers Map hdr
        , Exchange exch
) throws Exception
{

    Connection conn = null;
    PreparedStatement stmt=null;



    try 
    {


        conn= dataSource.getConnection();
        stmt =conn.prepareStatement("SOME INSERT STATEMENT");   

        stmt.setString(1,msgBody.getAccountNumber().trim());
        stmt.setString(2,msgBody.getRecordType().trim() );
        stmt.setString(3,msgBody.getSequenceNumber().trim());
        stmt.setString(4,msgBody.getTitle().trim());
        stmt.setString(5,msgBody.getCustomerType().trim());
        stmt.setString(6,msgBody.getName().trim());
        stmt.setString(7,msgBody.getAccountAddress1().trim());


        stmt.executeUpdate();        






    }
    catch (Exception e)
    {

        throw new Exception(e.getMessage());

    }

    finally
    {
        try
        {
                if (stmt!=null)
                {
                    stmt.close();
                    stmt= null;
                }
                if (conn!=null)
                {
                    conn.close();
                    conn= null;
                }
        }
        catch(SQLException e)
        {

            throw new Exception(e.getMessage());

        }

    }


}