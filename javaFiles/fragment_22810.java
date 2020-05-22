@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ItemsSession {

    @Resource UserTransaction ut;
    @Resource DataSource datasource;  // you should define datasource on your application server

    ...
    public String updateDocument(Integer id,InputStream is) throws SQLException{
        // ...
        try (java.sql.Connection conn = datasource.getConnection();
            PreparedStatement pstmt=conn.prepareStatement("UPDATE Documents SET doc = ? WHERE id = ?")) {

            pstmt.setBinaryStream(1, is);
            pstmt.setLong(2, id);

            ut.begin();
            pstmt.executeUpdate();
            ut.commit();

        } catch (PersistenceException e){
            // ... error handling
        }

        return ...;
    }
...
}