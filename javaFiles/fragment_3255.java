while(rowIterator.hasNext()){

    row = (XSSFRow)rowIterator.next();

    if(row.getRowNum()==0) {
        continue;
    }

    List<String> record = new ArrayList<String>();
    Iterator<Cell> cellIterator = row.cellIterator();
    ...
    readFile();
}