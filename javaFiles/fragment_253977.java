HSSFRow row  =null;

int i=1;
for(Items item: tableViewForExcel.getItems()){
        row= spreadsheet.createRow(i);
        row.createCell(1).setCellValue(item.getComponent);
        //.... add other column data as well
        i++;
}