private FileInputStream inFile;
private POIFSFileSystem poiFile;
private XSSFRow row;
private XSSFCell cell;
private XSSFSheet excelSheet = null;
private XSSFWorkbook excelBook = null;

private static String outputFileName;

public void overwriteExcel(File file, List<String> newContent) {
    try {
        if (file.exists()) {
            inFile = new FileInputStream(file);
            // poiFile = new POIFSFileSystem(inFile);
            excelBook = new XSSFWorkbook(inFile);
            excelSheet = excelBook.getSheetAt(0);
            System.out.println("Here -> " + excelSheet.getLastRowNum());
        } else { // --Create the file
            excelBook = new XSSFWorkbook();
            excelSheet = excelBook.createSheet("Sheet1");
        }
        int i = 0;
        for (String val : newContent.toArray(new String[newContent.size()])) {
            if (val != null) {
                System.out.println("Row " + excelSheet.getLastRowNum());
                row = excelSheet.createRow(excelSheet.getLastRowNum() + 1);
                cell = row.createCell(0);
                cell.setCellValue(newContent.get(i++));

            }
        }
        FileOutputStream outFile = new FileOutputStream(file);
        excelBook.write(outFile);
        // outFile.flush();
        outFile.close();
    } catch (Exception ex) {
        /*
         * JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(),
         * "Warning!", JOptionPane.ERROR_MESSAGE);
         */
        ex.printStackTrace();
    }
}

public static void main(String args[]) {
    outputFileName = "demo4.xlsx";
    List<String> newContent = new ArrayList<>();
    newContent.add("Test Val1");
    newContent.add("Test Val2");
    newContent.add("Test Val3");
    WriteExcel test = new WriteExcel();
    test.overwriteExcel(new File(outputFileName), newContent);
}