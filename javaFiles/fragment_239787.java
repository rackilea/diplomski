public static Connection dbconn;
public static Statement qry;
public void solve(InputReader in,OutputWriter out) throws ClassNotFoundException
{
    try
    {   
        Class.forName("org.sqlite.JDBC");
        dbconn =DriverManager.getConnection("jdbc:sqlite:/home/src/db.db"); 
        System.out.println("Connected"); 
        PreparedStatement upd = dbconn.prepareStatement("INSERT INTO distances (Road_Name,Start_Latitude,Start_Longitude) VALUES (?, ?, ?)");
        dbconn.setAutoCommit(false);
        qry = dbconn.createStatement();
        qry.setQueryTimeout(30);
        ResultSet rs = qry.executeQuery("select * from edges;"); 
        while(rs.next())
        {
            upd.setString(1, rs.getString("Road_Name"));
            upd.setString(2, rs.getString("Start_Latitude"));
            upd.setString(3, rs.getString("Start_Longitude"));
            upd.executeUpdate();
        }
        dbconn.commit();
    }
    catch(Exception e)
    {
        System.out.println("Exception : "+e);
    }
}