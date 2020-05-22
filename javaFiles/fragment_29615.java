for (int i = 0; i < lastRow; i++) {
    Row row = sheet.getRow(i);
    Cell cell = row.getCell(jobCod);

    String tmp = cell.getRichStringCellValue().getString().toLowerCase();

    if (tmp.equals(jobName)) {
        return tmp;
    }
}

return null; // now return null