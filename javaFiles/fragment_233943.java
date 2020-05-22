...
FileOutputStream fileOut = new FileOutputStream(new File("testfile.xlsx"));
BufferedOutputStream bos = new BufferedOutputStream(fileOut);
workbook.write(bos); 
bos.close();
workbook.close();
...