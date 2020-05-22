import java.io.InputStream;
import java.io.FileInputStream;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;

import java.util.Iterator;

public class ExcelXSSFGetSheetNamesXSSFReader {

 public static void main(String[] args) throws Exception {

  OPCPackage pkg = OPCPackage.open(new FileInputStream("Example.xlsx"));
  XSSFReader r = new XSSFReader( pkg );
  Iterator<InputStream> sheets = r.getSheetsData();

  if (sheets instanceof XSSFReader.SheetIterator) {
   XSSFReader.SheetIterator sheetiterator = (XSSFReader.SheetIterator)sheets;

   while (sheetiterator.hasNext()) {
    InputStream dummy = sheetiterator.next();

    System.out.println(sheetiterator.getSheetName());

    dummy.close();
   }
  }

  pkg.close();
 }
}