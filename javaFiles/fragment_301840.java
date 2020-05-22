TableColumnModel tcm = jTable1.getColumnModel();
HSSFRow fRow = fSheet.createRow((short) 0);

for(int j = 0; j < tcm.getColumnCount(); j++) {

   HSSFCell cell = fRow.createCell((short) j);
   cell.setCellValue(tcm.getColumn(j).getHeaderValue().toString());           

}