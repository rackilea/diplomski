import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class MyClass {

    public static void main(String[] args) {
        WritableWorkbook workbook;
        try {
            workbook = Workbook.createWorkbook(new File("C:\\IronMan.xls"));
            WritableSheet sheet = workbook.createSheet("Tony", 0);
            Label label = new Label(0, 0, "Real Name");
            sheet.addCell(label);
            Label label1 = new Label(1, 0, "Character Name");
            sheet.addCell(label1);
            Label label2 = new Label(2, 0, "Ability");
            sheet.addCell(label2);
            workbook.write();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}