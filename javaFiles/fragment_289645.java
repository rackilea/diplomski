import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
...
for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
  row = sheet.getRow(rowIndex);
  if (row != null) {
    Cell cell = row.getCell(colIndex);
    if (cell != null) {
      // Found column and there is value in the cell.
      cellValueMaybeNull = cell.getStringCellValue();
      // Do something with the cellValueMaybeNull here ...
    }
  }
}