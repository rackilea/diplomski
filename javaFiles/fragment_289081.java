import org.apache.poi.ss.usermodel.DateUtil;

case Cell.CELL_TYPE_NUMERIC:
   if (DateUtil.isCellDateFormatted(cell)) {
      // your code for date handling
   } else {
      cellValue = cell.getNumericCellValue();
   }