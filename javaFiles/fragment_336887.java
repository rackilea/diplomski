int pv1ColumnIndex = 1;
List<Double> pv1Columns = new ArrayList<>();
for(int row = 1;row < rows;row++){// row = 1 to skip the header
    String pv1 = sheet.getCell(pv1ColumnIndex, row).getContents();
    pv1Columns.add(Double.parseDouble(pv1)); 
}