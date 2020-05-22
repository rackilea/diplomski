String id8=request.getParameter("id8"); //Country field  
String id9=request.getParameter("id9"); //City field
String id10=request.getParameter("id10"); //URL field
int id = -1;

Class.forName("com.mysql.jdbc.Driver"); 
String myDatabase = "jdbc:mysql://localhost:3306/project_app?user=root&password=1234"; 
Connection myConnection = DriverManager.getConnection(myDatabase);
Statement myStatement = myConnection.createStatement();  

String sqlInsert = "INSERT INTO dest(Country,City,URL) VALUES ('"+id8+"', '"+id9+"','"+id10+"')";
myStatement.executeUpdate(sqlInsert);
ResultSet rs = myStatement.executeQuery("SELECT idDest FROM dest WHERE Country='"+id8+"' AND City='"+id9+"' AND URL='"+id10+"'" );
while (rs.next()) {
    id=rs.getInt(1);
}
String cat[]=request.getParameterValues("dest1");

if(id > -1)
{
    int insert_ch;
    for(int i=0;i<cat.length;i++)
    {
      insert_ch=myStatement.executeUpdate("INSERT INTO Dest_has_Categories (Dest_idDest,Categories_idCategories) VALUES ('"+id+"','"+cat[i]+"')");
    }
}