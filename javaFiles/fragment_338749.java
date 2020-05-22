File inputFile = new File("D://"+file_name);
File outputFile = new File("D://"+file_name);
Workbook readCopy = Workbook.getWorkbook(inputFile);
WritableWorkbook writeCopy = Workbook.createWorkbook(outputFile,readCopy);

// instructions to put content in specific rows, specific columns

readCopy.close();    
inputFile.close();
writeCopy.write();
writeCopy.close();
outputFile.close();