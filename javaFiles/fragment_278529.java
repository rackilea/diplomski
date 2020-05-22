import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExCell {

/**
 * @param args
 * @throws IOException 
 */
public static void main(String[] args) throws IOException {

    Workbook myWorkBook = new XSSFWorkbook();

    Sheet mySheet = myWorkBook.createSheet("Main");
    Row row = mySheet.createRow(0);

    Font font = myWorkBook.createFont();
    font.setColor(IndexedColors.BLUE.getIndex());
    CellStyle style = myWorkBook.createCellStyle();
    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
    style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
    style.setFont(font);

    Cell newCell = row.createCell(7);
    newCell.setCellValue("Question");
    newCell.setCellStyle(style);

    row.createCell(8).setCellValue("Option a");
    row.createCell(9).setCellValue("Option b");
    row.createCell(10).setCellValue("Option c");
    row.createCell(11).setCellValue("Option d");

    FileOutputStream fileOut = new FileOutputStream("Sandeep.xlsx");

    myWorkBook.write(fileOut);
    fileOut.close();
    myWorkBook.close();

    System.out.println("Done");
}