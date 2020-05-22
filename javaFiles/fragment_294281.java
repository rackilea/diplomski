public String getExcellContent(String sheetName, int row, int col){     
        String data = null;
        sheet1  = wb.getSheet(sheetName);  
        XSSFCell gcell=null;
        XSSFRow row1=sheet1.getRow(row);//Create Row.
        if(row1!=null)
        {

        gcell=row1.getCell(col);//Create Cell
        if(gcell!=null)
        {
        int getType = gcell.getCellType();
        if(getType == 0) {
            Double data1 = gcell.getNumericCellValue();
            int x1  =  data1.intValue();
            data = String.valueOf(x1);
        }
        else if(getType == 1) {
            data = gcell.getStringCellValue();
        }else {
            data = "Nothing";
        }
        }
        }
        return data;        
    }