int lastRowNum1 = sheet1.getLastRowNum();

int i=0;
int currentLinePos=sheet0.getLastRowNum();
while ( i <= lastRowNum1 ){
    Row currentRow = sheet1.getRow(i++);
    Row copiedRow = sheet0.createRow(currentLinePos++);
    // code that copy the content of currentRow into copiedRow
    // such as copying every cells
    // or try copiedRow = currentRow; but not sure it will copy the cells
}