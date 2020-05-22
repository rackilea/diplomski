int rows = sheet.getRows();
int columns = sheet.getColumns();
int i = 1;
if(i<rows)
    Cell[] rowCells = sheet.getRow(i);  //Won't throw an Exception

if(i<rows && j<columns)
    Cell cell = sheet.getCell(i,j);