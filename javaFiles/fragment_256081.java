rowPos = sheet.getLastRowNum();
for (Entry<String, String> entry : tushMap.entrySet()) {
    rowPos++;
    Row currentRow = sheet.getRow(rowPos);
    if(null == currentRow)
        currentRow = createRow(rowPos);