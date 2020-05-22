Workbook wb = WorkbookFactory.create(new File("myFile.xls")); // Or .xlsx
 Sheet s = wb.getSheet(0);
 Row r1 = s.getRow(0);
 r1.createCell(4).setCellValue(4.5);
 r1.createCell(5).setCellValue("Hello");

 FileOutputStream out = new FileOutputStream("newFile.xls"); // Or .xlsx
 wb.write(out);
 out.close();