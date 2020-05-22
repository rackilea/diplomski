while(rowIterator.hasNext()) {

    Row row = rowIterator.next();

    // for each row, iterate through each columns
    Iterator<Cell> cellIterator = row.cellIterator(); 
    key = null;  
    value = new ArrayList<String>();     

    while(cellIterator.hasNext()) {

        Cell cell = cellIterator.next();
        int columnIndex = cell.getColumnIndex();

        if(columnIndex == 1) {
            key = cell.getStringCellValue();
        } else {
            value.add(cell.getStringCellValue());
        }
    }

    if(key != null && value != null) {
        map.put(key, value);
        key = null;
        value = null;
    }
}