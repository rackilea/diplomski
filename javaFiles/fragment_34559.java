if (sheet != null && sheet.getRow(1) != null) {
    XSSFRow row = sheet.getRow(1);

    if (row.getCell(2) != null) {
        XSSFCell cell = row.getCell(2);
        cell.setCellValue(strText);
    }

    if (row.getCell(3) != null) {
        XSSFCell cell2 = row2.getCell(3);
        cell2.setCellValue(strText1);
    }
}