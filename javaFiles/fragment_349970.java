import com.monitorjbl.xlsx.StreamingReader;

public static StreamingReader getExcelSheet(File excelFile, String sheetName) throws Exception{
        StreamingReader reader = null;
        reader = StreamingReader.builder()
                .rowCacheSize(100) // number of rows to keep in memory (defaults to 10)
                .bufferSize(4096) // buffer size to use when reading InputStream to file (defaults to 1024)
                .sheetName(sheetName) // index of sheet to use (defaults to 0)
                .read(excelFile);
        return reader;
    }

StreamingReader sheet1 = FileUtility.getExcelSheet(excelFile, sheetName);   
for (Row r : sheet1){

    // iterate row here

    for (Cell cell : r) {

    //iterate cells here

    }

}