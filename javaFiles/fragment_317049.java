Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;

public Dbconnection()
 {
    try{

            Class.forName("com.mysql.jdbc.Driver");
                 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/databasename","root","root"); 
        }
        catch(Exception e)
        {
            System.out.println("Error in connection"+e);
        }
}