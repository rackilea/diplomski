import java.io.*;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class PoiPattern {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) throws Exception {
        Map<String, ArrayList<String>> matrix = new HashMap<String, ArrayList<String>>();
        for (int i = 1; i <= 5; i++) {
            matrix.put("hashkey"+i, new ArrayList(Arrays.asList(new String[]{"value"+i+"-1", "value"+i+"-2", "value"+i+"-3", "value"+i+"-4", "value"+i+"-5"})));    
        }

        Workbook wb = new HSSFWorkbook();
        Sheet worksheet = wb.createSheet();

        Row keyRow = worksheet.createRow(0);
        int col = 0;
        for (String key : matrix.keySet()) {
            keyRow.createCell(col).setCellValue(key);
            ArrayList<String> values = matrix.get(key);
            for (int i = 0; i < values.size(); i++) {
                Row r = worksheet.getRow(i+1);
                if (r == null) { r = worksheet.createRow(i+1); }
                r.createCell(col).setCellValue(values.get(i));
            }
            col++;
        }
        FileOutputStream fos = new FileOutputStream(new File("ExampleFill.xls"));
        wb.write(fos);
    }
}