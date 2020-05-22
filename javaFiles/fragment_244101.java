for(int i=0;i<arr.size();i++){
    row = spreadSheet.createRow((short) i);
    cell = row.createCell(0);
    System.out.println(arr.get(i));
    cell.setCellValue(arr.get(i).toString());
}