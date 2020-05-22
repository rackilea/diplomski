XSSFSheet sheet = workbook.getSheetAt(0);

for (i = 0; a <= name.length; i++,a++)
{
    Cell cell = null;
    cell = sheet.getRow(0).getCell(4);
    XSSFSheet newSheet = workbook.createSheet(name[i]);
    // createRow and createCell should come to rescue here.
    Cell cellInNewSheet = newSheet.getRow(0).getCell(4);          
    if (cell.getStringCellValue().equals(match)) {
        cellInNewSheet.setCellValue(name[i]);
    }
    else {
        JOptionPane.showMessageDialog(null, "No match found.");
    }
    System.out.println(name[i]);
}