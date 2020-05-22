{
if (index < sheet.getRow(row).length) {
    String i = sheet.getCell(index, row).getContents();
    column.add(Double.parseDouble(i));
    }
}