// Lookup from number format to the coloured version
Map<String,CellStyle> styles = new Hashmap<String,CellStyle>();

// Method to make the cell a different colour
public void fillCell(Workbook wb, Row row, int errorColumn){
   Cell cell = row.getCell(j);

   // Try to find a coloured one for this data formatting
   String formatStr = cell.getCellStyle().getDataFormatString();
   CellStyle cs = styles.get(formatStr);
   if (cs == null) {
      // Need to create a new coloured one
      cs =  wb.createCellStyle();
      cs.setFillForegroundColor((short) 10);
      cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
      cs.setDataFormat(
           wb.getCreationHelper().createDataFormat().getFormat(formatStr));
      // Save this for later
      styles.put(formatStr, cs);
   }

   // Apply the coloured form, with the format string  
   cell.setCellStyle(cs);
}