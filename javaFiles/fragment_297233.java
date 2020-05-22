titleLenght = 2;
cell1.setCellValue(excelTitle);

boolean headerStyle = true;
for (int j = 0; j < list.size(); j++) {
    Row row = mySheet.createRow(j+2+titleLength);
    List<String> l2= list.get(j);
    for(int k=0; k<l2.size(); k++)
    {
        Cell cell = row.createCell(k);
        cell.setCellValue(l2.get(k));
        if(headerStyle){
            **cell.setCellStyle(headingCellStyle);
            int origColWidth = mySheet.getColumnWidth(k);
            mySheet.autoSizeColumn(k);
            // Making sure col width is not going less than the header width
            if (origColWidth > mySheet.getColumnWidth(k)) {
                mySheet.setColumnWidth(k, origColWidth);
            }**
        }else{
            cell.setCellStyle(dataCellStyle);
        }
    }   
    headerStyle = false;
}


// Set title style element at last so the first column will not take
// width of title field
cell1.setCellStyle(titleCellStyle);