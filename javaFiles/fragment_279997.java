public static void main(String[] args) throws IOException, RowsExceededException, WriteException {

    File file = new File("output.xls");
    WritableWorkbook workbook = Workbook.createWorkbook(file);
    WritableSheet sheet = workbook.createSheet("First Sheet", 0);

    Number number = addNumber(sheet, 3, 2, 565d);

    WritableCellFeatures wcf = number.getWritableCellFeatures();
    if (wcf == null) wcf = new WritableCellFeatures();
    wcf.setComment("the comment");
    number.setCellFeatures(wcf);

    workbook.write(); 
    workbook.close();

}

private static Number addNumber(WritableSheet sheet, int column, int row,
        double d) throws WriteException, RowsExceededException {

    Number number = new Number(column, row, d, timesStandard);
    sheet.addCell(number); // need to add the cell first
    return number;
}