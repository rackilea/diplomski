String sql = "Select Name from yourTableNameHere";

Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery( sql );
List<String> names = new ArrayList<String>();

while (rs.next())
{
    names.add( rs.getString(1) );
}

rs.close();
stmt.close();

System.out.println( names );