...

List<List<String>> records = new ArrayList<List<String>>();

while(rowIterator.hasNext()){
    List<String> record = new ArrayList<String>();

    row = (XSSFRow)rowIterator.next();

    Iterator<Cell> cellIterator = row.cellIterator();

    while(cellIterator.hasNext()){
        cell = cellIterator.next();
        cell.setCellType(Cell.CELL_TYPE_STRING);

        switch(cell.getCellType()){
            case Cell.CELL_TYPE_STRING:
                record.add(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                record.add(Double.toString(cell.getNumericCellValue()));
                break;
        }
    }

    records.add(record);
}

for (List<String> record : records) {
    for (String s : record) {
        System.out.print(" " + s);
    }

    System.out.println();
}

...