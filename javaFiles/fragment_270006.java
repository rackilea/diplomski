static List<Map<String, String>> excelData = new ArrayList<HashMap<String, String>>();

public static String readWriteExcel(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException, JSONException
{
    File file = new File("File Path");
    FileInputStream inputStream = new FileInputStream( file );
    Workbook workbook = WorkbookFactory.create( inputStream );

    Sheet sheet = workbook.getSheet( "sheetName" );
    int rowCount = sheet.getLastRowNum(); 
    for(int i=1;i<=rowCount;i++){
        Row row = sheet.getRow(0);
        Map<String,String> rowData = new HashMap<>();
        for(int j=0;j<row.getLastCellNum();j++) {
            String key=row.getCell(j).getStringCellValue();
            String value=sheet.getRow(i).getCell(j).getStringCellValue();
            rowData.put(key, value);
        }
        excelData.add(rowData);
    }

}