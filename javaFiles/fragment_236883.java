String label = request.getParameter("label"); 
//retrieving a variable from a previous page

Connection dbc = null; //Make connection to the database
Class.forName("com.mysql.jdbc.Driver");
dbc = DriverManager.getConnection("jdbc:mysql://localhost:3306/works", "root", "root");

if (dbc != null) 
{
    System.out.println("Connection successful");
}
ResultSet rs = listresult.dbresult.func(dbc, label); 
//The above function is mentioned in the end. 
//It is defined in another package- listresult

while (rs.next()) 
{
%>
<form name="demo form" method="post">
    <table>
        <tr>
            <td>
                Label Name:
            </td>
            <td>
                <input type="text" name="label" 
                value="<%=rs.getString("lname")%>">
            </td>
        </tr>
    </table>
</form>
<% } %>


public static ResultSet func(Connection dbc, String x)
{
    ResultSet rs = null;
    String sql;
    PreparedStatement pst;
    try
    {
        sql = "select lname from demo where label like '" + x + "'";
        pst = dbc.prepareStatement(sql);
        rs = pst.executeQuery();
    } 
    catch (Exception e) 
    {
        e.printStackTrace();
        String sqlMessage = e.getMessage();
    }
    return rs;
}