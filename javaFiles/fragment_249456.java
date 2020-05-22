CellStyle style = null;
row = sheet.createRow(lines);
String[] parts = sCurrentLine.split("\\|");

if (sCurrentLine.contains("X")) {
    style = styleX;
} else if (sCurrentLine.contains("Y")){
    style = styleY;
} else if (sCurrentLine.contains("Z")) {
    style = styleZ;
} else {
    style = styleOther;
}
for (short i = 0; i < parts.length; i++) {
    row.createCell(i).setCellValue(parts[i]);
    HSSFCell curCell = row.getCell(i);
    currCell.setCellStyle(style);
}