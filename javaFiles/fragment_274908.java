//Note - changed temp table to a List of String[] members,
//replacing one long list of Strings.
ArrayList<String[]> tempTable = new ArrayList<String[]>();

//Turn each row into a String[] and then add it to the list
while(rs.next())
{
    int i = 1; 
    String[] rowData = new String[columns];
    while(i<=columns)
    {
        rowData[i] = rs.getString(i++);
    }
    tempTable.add(rowData);
}