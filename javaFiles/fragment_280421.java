resTablesData1.next();
String rowData = resTablesData1.getString(db1ColName);
for (int j=0; j<db1RowNum; j++)
{
    System.out.println();
    for (int k=0; k<db1ColNum; k++)
    {
        columnsArrayDB1[j][k] = rowData;
        System.out.println("|-----------------------------------------------------|");
        System.out.print("| "+columnsArrayDB1[j][k]+" |"+"\t");
        System.out.println("|-----------------------------------------------------|");
    }
}