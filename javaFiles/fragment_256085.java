dataTemp = new Vector();  // added

while(cellIterator.hasNext())
{
    Cell cell = cellIterator.next();
    if(rowIterator.hasNext())
    {
        if(cell.getCellType() == Cell.CELL_TYPE_STRING)
        {
            dataTemp.add(cell.getStringCellValue());
        }
        else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
        {
            dataTemp.add(cell.getNumericCellValue());
        }
        //data.addElement(dataTemp);
    }
    else
    {
        break;
    }
}

data.add( dataTemp ); // added