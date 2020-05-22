import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationship;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.regex.Pattern;

class ReadXSLMWriteXLSXWorkbook {

 public static void main(String[] args) throws Exception {

  XSSFWorkbook workbook = (XSSFWorkbook)WorkbookFactory.create(new FileInputStream("Workbook.xlsm"));

  OPCPackage opcpackage = workbook.getPackage();

  //get and remove the vbaProject.bin part from the package
  PackagePart vbapart = opcpackage.getPartsByName(Pattern.compile("/xl/vbaProject.bin")).get(0);
  opcpackage.removePart(vbapart);

  //get and remove the relationship to the removed vbaProject.bin part from the package
  PackagePart wbpart = workbook.getPackagePart();
  PackageRelationshipCollection wbrelcollection = wbpart.getRelationshipsByType("http://schemas.microsoft.com/office/2006/relationships/vbaProject");
  for (PackageRelationship relship : wbrelcollection) {
   wbpart.removeRelationship(relship.getId());
  }

  //set content type to XLSX
  workbook.setWorkbookType(XSSFWorkbookType.XLSX);

  Sheet sheet = workbook.getSheetAt(0);
  Row row = sheet.getRow(0);
  if (row == null) row = sheet.createRow(0);
  Cell cell = row.getCell(0);
  if (cell == null) cell = row.createCell(0);
  cell.setCellValue("changed");

  workbook.write(new FileOutputStream("Workbook.xlsx"));
  workbook.close();

 }
}