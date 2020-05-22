String query = Request.getParameter('query');
ResultSet rs = MyDbClass.executeQuery(query);


ResultSetMetaData rsmd = rs.getMetaData();
int colCount           = rsmd.getColumnCount();

while (rs.next())
{
    for (int i = 1; i <= colCount; i++)
    {
        String columnName = rsmd.getColumnName(i);
        Object value      = rs.getObject(i);
        out.println(columnName+":"+value.toString()+'\t');
    }
    out.println("\r\n");
}