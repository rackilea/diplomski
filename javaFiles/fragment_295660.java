import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

import java.nio.file.Paths;
import java.nio.file.Files;

import java.nio.file.StandardOpenOption;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

class ExcelReadUnicode {

 public static void main(final String[] args) throws Exception {

  try (Workbook workbook = WorkbookFactory.create(new FileInputStream("input.xlsx"))) {

   String str = workbook.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();

   String format = "%-30s%-25s%n";
   System.out.format(format, "Representation of String", str);
   System.out.format(format, "Length of String", str.length());
   System.out.format(format, "Code Point Length of String", str.codePointCount(0, str.length()));
   System.out.format(format, "Multi-byte Characters", Character.isSurrogatePair(str.charAt(0), str.charAt(1)));

   Charset[] charsets = new Charset[] {
                               StandardCharsets.UTF_16BE, 
                               StandardCharsets.UTF_16LE, 
                               StandardCharsets.UTF_8
                              }; // those charsets needs BOMs manually added

   for (Charset charset : charsets ) {
    Files.write(Paths.get("out_" + charset.name() + ".txt"), 
                ("\uFEFF" + str).getBytes(charset), // write out a BOM before the content
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING); 
   }

   Files.write(Paths.get("out_" + StandardCharsets.UTF_16.name() + ".txt"), 
               str.getBytes(StandardCharsets.UTF_16), // UTF-16 puts BOM per default
               StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING); 
  }

 }

}