for(int i = 0; i < sheet.getLastRowNum(); i++)
{
    row = sheet.getRow(i);
    if(patternt.equals(getCurrentString(row)))
    {
        data.add(getDataFromRow(row));
        // sheet.removeRow(row);    NO NEED FOR THIS LINE
        sheet.shiftRows(row.getRowNum() + 1, sheet.getLastRowNum() + 1, -1);
        i--;
    }
}