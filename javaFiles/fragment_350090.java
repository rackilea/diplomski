import java.io.*;
import org.apache.poi.ss.usermodel.*;
import java.text.*;

public class XSLXReader {
    static DecimalFormat df = new DecimalFormat("#####0");

    public static void main(String[] args) {
        FileWriter fostream;
        PrintWriter out = null;
        String strOutputPath = "D:\\Proj\\Current_\\";
        String strFilePrefix = "Master 5.2-B";

        try {
            InputStream inputStream = new FileInputStream(new File("D:\\Proj\\Current_\\Master A-B.xlsx"));
            Workbook wb = WorkbookFactory.create(inputStream);
            Sheet sheet = wb.getSheet("Bin-code");

            fostream = new FileWriter(strOutputPath + "\\" + strFilePrefix+ ".xml");
            out = new PrintWriter(new BufferedWriter(fostream));

            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            out.println("<Bin-code>");

            boolean firstRow = true;
            for (Row row : sheet) {
                if (firstRow == true) {
                    firstRow = false;
                    continue;
                }
                out.println("\t<DCT>");
                out.println(formatElement("\t\t", "ID", formatCell(row.getCell(0))));
                out.println(formatElement("\t\t", "Variable", formatCell(row.getCell(1))));
                out.println(formatElement("\t\t", "Desc", formatCell(row.getCell(2))));
                out.println(formatElement("\t\t", "Notes", formatCell(row.getCell(3))));
                out.println("\t</DCT>");
            }
            out.write("</Bin-code>");
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String formatCell(Cell cell)
    {
        if (cell == null) {
            return "";
        }
        switch(cell.getCellType()) {
            case Cell.CELL_TYPE_BLANK:
                return "";
            case Cell.CELL_TYPE_BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case Cell.CELL_TYPE_ERROR:
                return "*error*";
            case Cell.CELL_TYPE_NUMERIC:
                return XSLXReader.df.format(cell.getNumericCellValue());
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            default:
                return "<unknown value>";
        }
    }

    private static String formatElement(String prefix, String tag, String value) {
        StringBuilder sb = new StringBuilder(prefix);
        sb.append("<");
        sb.append(tag);
        if (value != null && value.length() > 0) {
            sb.append(">");
            sb.append(value);
            sb.append("</");
            sb.append(tag);
            sb.append(">");
        } else {
            sb.append("/>");
        }
        return sb.toString();
    }
}