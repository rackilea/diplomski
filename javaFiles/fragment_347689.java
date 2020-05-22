File destFile = new File("/test.xls");
FileInputStream fileStream = new FileInputStream(destFile);
POIFSFileSystem fsPoi = new POIFSFileSystem(fileStream);

HSSFWorkbook workbook = new HSSFWorkbook(fsPoi);

int index = 0;

HSSFSheet sheet = workbook.getSheet("Setup");
if(sheet != null)   {
    index = workbook.getSheetIndex(sheet);
    workbook.removeSheetAt(index);
}
workbook.createSheet("Setup");
FileOutputStream output = new FileOutputStream(destFile);
workbook.write(output);
output.close();