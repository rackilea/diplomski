int j = 0;
while(resTablesData1.next())
{
    ResultSetMetaData rsmd = resTablesData1.getMetaData();
    int colCount = rsmd.getColumnCount();
    System.out.println();
    for (int k=0; k<colCount ; k++)
    {
        String colName = rsmd.getColumnName(i);
        Object o = resTablesData1.getObject(colName);
        columnsArrayDB1[j][k] = o.toString();
        System.out.println("|-----------------------------------------------------|");
        System.out.print("| "+columnsArrayDB1[j][k]+" |"+"\t");
        System.out.println("|-----------------------------------------------------|");
    }
    j++;
}