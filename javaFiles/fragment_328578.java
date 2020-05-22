ResultSet columns = dbmd.getColumns(null, null, tableName, null);
final List<String> columnList = new ArrayList<String>();
while (columns.next())
{
     columnList.add(columns.getString(4));
}