String lookFor = "B";
for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
    Row r = sheet.getRow(rowNum);

    boolean found = false;

    // cell
    for (int i = 0; i < r.getLastCellNum(); i++) {
        Cell cell = r.getCell(i);
        String stringcell = formatter.formatCellValue(cell);
        if (stringcell .equals(lookFor)) {
               rowNum++;
               lookFor = "D";
               found = true;
               break;
        }
    }    
    if (found) {
        System.out.println(lookFor  + " found");
    }        
    else {
        System.out.println(lookFor  + " not found");
    }
}