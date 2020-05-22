List<RowDataObject> allRows = new ArrayList<RowDataObject>();

ResultSet rs = //Your Query
while (rs.next())
{
     String c1 = rs.getString("A Column Name or Index");
     String c2 = rs.getString("A Column second Name or Index");
     //...etc
     allRows.add(new RowDataObject(c1,c2......));
}