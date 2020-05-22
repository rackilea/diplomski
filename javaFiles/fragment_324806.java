for(int i=1; i <= excel.length; i++){  
  HSSFRow row = sheet.createRow(i);
  final int j = i - 1; // <-- it's actually the row index into finalExcel (0 based).
  for(int k=0; k < finalExcel[j].length; k++){
    row.createCell(k).setCellValue(finalExcel[j][k]);
    System.out.print(finalExcel[j][k]+" ");
  }
  System.out.println();
}