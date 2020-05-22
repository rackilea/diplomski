private Cell readName(String name){
    Iterator<Row> rowIterator = librarianSheet.iterator();
    while (rowIterator.hasNext()) {
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            if(cell.getCellType() == CellType.STRING){
                String random = cell.getStringCellValue();
                if(random.equals(name)){
                    return cell;
                }
            }
        }
    }
    return null;
}