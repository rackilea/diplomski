Vector<Double> firstRow = new Vector<>();
if(rows > 0){
    for(int col = 0;col < columns;col++){
        String pv = sheet.getCell(1, col).getContents();
        firstRow.add(Double.parseDouble(pv)); 
    } 
}