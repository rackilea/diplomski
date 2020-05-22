public static void editFile(int roww, int cell) {
try {

    FileInputStream file = new FileInputStream(new File("samefile"));

    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet = workbook.getSheetAt(0);


        XSSFRow row = sheet.getRow(roww);
        row.createCell(cell).setCellValue("FALSE");

    file.close();

    FileOutputStream outFile = new FileOutputStream(
            new File("samefile"));
    workbook.write(outFile);
    outFile.close();

    System.out.printf("DONE UPDATE");

} catch (Exception e) {
    e.printStackTrace();
}