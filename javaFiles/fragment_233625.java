import com.monitorjbl.xlsx.*;
import org.apache.poi.ss.usermodel.*;

import java.io.*;

class StreamingReaderTest {

 public static void main(String[] args) throws Exception {

  try (
   InputStream is = new FileInputStream(new File("/home/axel/Downloads/test_formatted_number.xlsx"));
   StreamingReader reader = StreamingReader.builder()
           .rowCacheSize(100)
           .bufferSize(4096)
           .sheetIndex(0)
           .read(is);
  ) {
   for (Row row : reader) {
    System.out.println("row[0] is of type " + row.getCell(0).getCellType());
    Cell cell = row.getCell(0);
    String value = "";
    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
        value = cell.getStringCellValue();
    } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
        value = new DataFormatter().formatCellValue(cell);
    }
    System.out.println("Value is " + value);
   }
  }
 }
}