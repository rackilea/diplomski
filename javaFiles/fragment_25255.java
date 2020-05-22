static int cellNum = 7;
for (int x = 0; x < projectLocationList.size(); x++) {
    columnHeaderCell = regionList.createCell(cellNum);
    columnHeaderCell.setCellValue(projectLocationList.get(x));
    columnHeaderCell.setCellStyle(columnHeaderStyle);
cellNum = cellNum + 3;
}