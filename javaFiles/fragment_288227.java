HSSFWorkbook wBook = new HSSFWorkbook(new FileInputStream("your_path"));  
for(int i = 0; i < wBook.getNumberOfSheets(); i++){
       System.out.println("Sheet " + i + " has data: " + isSheetEmpty(wBook.getSheetAt(i)));
}
boolean isSheetEmpty(HSSFSheet sheet){
       Iterator rows = sheet.rowIterator();
       while (rows.hasNext()) {
           HSSFRow row = (HSSFRow) rows.next();
           Iterator cells = row.cellIterator();
           while (cells.hasNext()) {
                HSSFCell cell = (HSSFCell) cells.next();
                if(!cell.getStringCellValue().isEmpty()){
                    return true;
                }
           }
       }
       return false;
}