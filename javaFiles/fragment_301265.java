List<HSSFRow> filteredRows = new ArrayList<HSSFRow>();
Iterator<Row> rows= sheet.rowIterator(); 
while (rows.hasNext ()){
HSSFRow row = (HSSFRow) rows.next ();  
 Iterator<Cell> cells = row.cellIterator (); 
 while (cells.hasNext ()){
    HSSFCell cell = (HSSFCell) cells.next (); 
    if (cell.toString().contains("GHH")) {
        String key = cell.getStringCellValue();
        int RI=cell.getRowIndex();
        filteredRows.add(row);
        break;
    }
}
// then use filteredRows