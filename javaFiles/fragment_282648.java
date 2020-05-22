//Read the spreadsheet that needs to be updated
FileInputStream fsIP= new FileInputStream(new File("C:\\Excel.xls"));  
//Access the workbook                  
HSSFWorkbook wb = new HSSFWorkbook(fsIP);
//Access the worksheet, so that we can update / modify it. 
HSSFSheet worksheet = wb.getSheetAt(0); 
// declare a Cell object
Cell cell = null; 
// Access the second cell in second row to update the value
cell = worksheet.getRow(1).getCell(1);   
// Get current cell value value and overwrite the value
cell.setCellValue("OverRide existing value");
//Close the InputStream  
fsIP.close(); 
//Open FileOutputStream to write updates
FileOutputStream output_file =new FileOutputStream(new File("C:\\Excel.xls"));  
 //write changes
wb.write(output_file);
//close the stream
output_file.close();