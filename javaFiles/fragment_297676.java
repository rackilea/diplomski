for(Data d: allData){
   Row row = sheet.createRow(++row);
   Cell c = row.createCell(0);
   c.setCellValue("something01");
   c = row.createCell(1);
   c.setCellValue("something02")
   //etc..

   // Add extra rows:
   row = sheet.createRow(++row);
   c = row.createCell(0);
   c.setCellValue("something11");
   c = row.createCell(1);
   c.setCellValue("something12")
   //etc..
}