String[][] outArr = new String[tempTable.size()][columns];
int i = 0;
for (rowArr : tempTable)
{
    System.arraycopy(rowArr,0,outArr[i++],0,columns);
}