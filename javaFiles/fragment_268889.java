for (int rn = 1; rn <= 4; rn++) {
    Row row = sheet1.createRow(rn);
    for (int i = 0; i < 4; i++) {
        row.createCell(i).setCellValue(Month[rn-1]);
    }
}