...    
    createVal(sheet1, createHelper, 5); 
    createVal(sheet2, createHelper, 10); 
    createVal(sheet3, createHelper, 15);
    createVal(sheet4, createHelper, 20); 

    Sheet sheet = wb.createSheet("Total"); 
    Row row = sheet.createRow((short)0); 
    Cell cell = row.createCell(0); 

    cell.setCellFormula("a!A1+b!A1+c!A1");