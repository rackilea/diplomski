public class ClientApproveDAO {

        private DataSource dataSource;
        public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;
    }
    Connection conn=null;
    PreparedStatement statement=null;
    ResultSet rs=null;


    public void insertClient(int id) {    
        try{
            conn=dataSource.createConnection();
            PreparedStatement ps=conn.prepareStatement("insert into login(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.executeUpdate("insert into login(id,FirstName,LastName,Gender,Category,Dateofbirth,Age,Address,Country,State,city,PinCode,EmailId,ContactNo,MobileNo)select * from register where id="+id+"");
            ps.setInt(1, id);

        }
        catch (SQLException e) {
            throw new RuntimeException(e);

    } finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
    }


    }

}