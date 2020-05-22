private void cleaner(Integer columnsCount, Integer rowsCount, Object object){
    XSSFSheet sheet = workBook.getSheetAt(0);
    for (int lineId=0; lineId < rowsCount; lineId++)   {
        XSSFRow row = sheet.getRow(lineId);
        if(row != null)
            for (int columnId=0; columnId < columnsCount; columnId++)
                row.createCell(columnId).setCellValue(object.toString());
    }
}