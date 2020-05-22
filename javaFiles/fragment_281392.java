Iterator<Cell> cellIterator = row.cellIterator();

String key = null
int value = Integer.MIN_VALUE; // use a default value that will never occur in the sheet

HashMap<String, Integer> map = new HashMap<String, Integer>();

while(cellIterator.hasNext()) 
{
    Cell cell = cellIterator.next();

    switch(cell.getCellType()) 
    {
        case Cell.CELL_TYPE_NUMERIC:
            value = cell.getNumericCellValue(); break;
        case Cell.CELL_TYPE_STRING:
             key = cell.getStringCellValue(); break;
    }

    if(key != null && value != Integer.MIN_VALUE)
    {
        map.put(key, value);
        key = null;
        value = Integer.MIN_VALUE;
    }
}