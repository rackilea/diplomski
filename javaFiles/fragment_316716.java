private String[] getColumnAsArray(Sheet sheet, String header) {
    List<String> values=new ArrayList<>();

    int columnOfIntrest=-1;

    //find the interresting column
        for(Cell cell:sheet.getRow(sheet.getFirstRowNum())){
            if(cell.getCellType()==Cell.CELL_TYPE_STRING && 
                    cell.getStringCellValue().equals("Mitesh")) {  //this is working
                columnOfIntrest = cell.getColumnIndex();
                break;
            }
        }
        //nothing found
        if(columnOfIntrest<0)
            return null;
        Iterator<Row> rowIter=sheet.iterator();

        if(rowIter.hasNext())
            rowIter.next(); //skip the first row

        while(rowIter.hasNext()){
            Cell currCell=rowIter.next().getCell(columnOfIntrest);

            switch (currCell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                values.add(currCell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                values.add(Boolean.toString(currCell.getBooleanCellValue()));
                break;
            case Cell.CELL_TYPE_NUMERIC:
                values.add(Double.toString(currCell.getNumericCellValue()));
                break;
            }
        }

    return values.toArray(new String[values.size()]);
}