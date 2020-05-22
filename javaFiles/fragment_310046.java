String userName;
if ("".equals(cell.getStringCellValue())) {
    userName = "BlankCell";
} else {
    userName = cell.getStringCellValue();
}