for(int i=0; i<rowCount;i++)
    {
        Map<Object, Object> mapData= new HashedMap<Object, Object>();
        for(int j=0;j<colCount;j++)
        {   
            if (sheet.getRow(i+1).getCell(j).getCellType() != CellType.STRING) {
                mapData.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).getNumericCellValue());
            } else {
                mapData.put(sheet.getRow(0).getCell(j).toString(), Double.parseDouble(sheet.getRow(i+1).getCell(j).getStringCellValue()));
            }
        }
        obj[i][0]= mapData;
    }