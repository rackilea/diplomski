import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;
import java.util.ArrayList;

public class TestScript {
 public static void main(String[] args) throws Exception {

  List<String> goodsNamesListCreating = new ArrayList<String>();
  goodsNamesListCreating.add("SmartsPopular Name 1");
  goodsNamesListCreating.add("SmartsPopular Name 2");
  goodsNamesListCreating.add("SmartsPopular Name 3");

  List<String> goodsPricesListCreating = new ArrayList<String>();
  goodsPricesListCreating.add("123");
  goodsPricesListCreating.add("456");
  goodsPricesListCreating.add("789");

  FileExcelCreating.create("SmartsPopular", goodsNamesListCreating, goodsPricesListCreating);

  goodsNamesListCreating = new ArrayList<String>();
  goodsNamesListCreating.add("Smarts 3-6 K Name 1");
  goodsNamesListCreating.add("Smarts 3-6 K Name 2");
  goodsNamesListCreating.add("Smarts 3-6 K Name 3");
  goodsNamesListCreating.add("Smarts 3-6 K Name 4");

  goodsPricesListCreating = new ArrayList<String>();
  goodsPricesListCreating.add("321");
  goodsPricesListCreating.add("654");
  goodsPricesListCreating.add("987");

  FileExcelCreating.create("Smarts 3-6 K", goodsNamesListCreating, goodsPricesListCreating);

 }
}

class FileExcelCreating {

 private static final String fileName = "./FilesTXT/Smartphones.xlsx";

 public static void create(String sheetName, List<String> goodsNames, List<String> goodsPrices) throws Exception {

  Workbook wb = null;
  File file = new File(fileName);
  if(file.exists()) {
   wb = WorkbookFactory.create(new FileInputStream(file));
  } else {
   wb = new XSSFWorkbook();
  }  

  Sheet sheet = wb.getSheet(sheetName); if(sheet == null) sheet = wb.createSheet(sheetName);

  Row row = sheet.createRow(0);
  Cell cell = row.createCell(0);
  cell.setCellValue("Name");
  cell = row.createCell(1);
  cell.setCellValue("Price");

  List<Integer> goodsPricesInt = new ArrayList<>();
  for(String s : goodsPrices) goodsPricesInt.add(Integer.valueOf(s));

  for (int i = 0; i < goodsNames.size(); i++) {
   row = sheet.createRow(i+1);
   String name = goodsNames.get(i);
   row.createCell(0).setCellValue(name);
   Integer price = (i < goodsPricesInt.size())?goodsPricesInt.get(i):null;
   if (price != null) row.createCell(1).setCellValue(price);
  }

  sheet.setAutoFilter(CellRangeAddress.valueOf("A1:B" + goodsNames.size()));

  FileOutputStream outputStream = new FileOutputStream(file);

  wb.write(outputStream);
  outputStream.close();
  wb.close();
 }
}