public static void appendData(int column, String data) throws BiffException, IOException, WriteException{
    Workbook file=Workbook.getWorkbook(inputWorkbook);
    WritableWorkbook writeBook=Workbook.createWorkbook(inputWorkbook,file);
    WritableSheet sheet = writeBook.getSheet(0);
    WritableFont wf=new WritableFont(WritableFont.ARIAL);
    WritableCellFormat cf = new WritableCellFormat(wf);
    cf.setWrap(true);
    Cell[] cell = sheet.getColumn(column);
    int len = cell.length;
    Label label = new Label(column, len, data,cf);
    sheet.addCell(label);
    writeBook.write();
    writeBook.close();
    return;
}