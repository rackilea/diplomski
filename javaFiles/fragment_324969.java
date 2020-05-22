for(int i = 0; i < outputTable.getRowCount()+1; i++)
{     
    String headers = String.valueOf(outputTable.getColumnName(i));
    fileWriter.print(headers);
    fileWriter.print("\t");
}