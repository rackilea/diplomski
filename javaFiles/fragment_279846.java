public WriteExcel(String FilePath) throws IOException

{
    this.FilePath=FilePath;
}

//Write to a specific Cell

public void writeToCell(String SheetName, int RowNum, int ColNum, String Data) throws IOException
{
    fout=new FileOutputStream(FilePath);
    wb=new XSSFWorkbook();
    ws=wb.createSheet(SheetName);
    xr=ws.createRow(RowNum);
    xc=xr.createCell(ColNum);
    xc.setCellValue(Data);
    wb.write(fout);
    fout.close();
}