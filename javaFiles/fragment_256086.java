Iterator<Row> rowIterator = sheet.iterator();

while(rowIterator.hasNext())
{
    Row row = rowIterator.next();
    Iterator<Cell> cellIterator = row.cellIterator();

    if(row.getRowNum() == 0)
    {
        while(cellIterator.hasNext())
        {
            Cell cell = cellIterator.next();
            columns.add(cell.getStringCellValue());
        }
    }
    else
    {
        dataTemp = new Vector();

        while(cellIterator.hasNext())
        {
            Cell cell = cellIterator.next();

            if(cell.getCellType() == Cell.CELL_TYPE_STRING)
            {
                dataTemp.add(cell.getStringCellValue());
            }
            else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
            {
                dataTemp.add(cell.getNumericCellValue());
            }
        }

        data.add( dataTemp );
    }