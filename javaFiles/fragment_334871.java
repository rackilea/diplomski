import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main{

    private static Workbook my_workbook;
    private static Sheet my_sheet;
    private static String imgPath;
    private static String excelPath;
    private static int row=0;

    public static void main(String args[]) throws IOException {
        init();

        openExcel();
        pasteInExcel();

        openExcel();
        pasteInExcel();

        openExcel();
        pasteInExcel();
    }

    private static void init() {
        excelPath = "C:\\temp\\test.xlsx";
        imgPath = "C:\\temp\\test-image.png";
    }

    private static void pasteInExcel() throws IOException {
        InputStream my_banner_image = new FileInputStream(imgPath);
        byte[] bytes = org.apache.poi.util.IOUtils.toByteArray(my_banner_image);
        int my_picture_id = my_workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        my_banner_image.close();
        XSSFDrawing drawing = (XSSFDrawing) my_sheet.createDrawingPatriarch();
        XSSFPicture my_picture = drawing.createPicture(getAnchorPoint(), my_picture_id);
        my_picture.resize();
        fileClose();
    }

    public static void openExcel() throws IOException {
        File f = new File(excelPath);

        if (!f.exists()) {
            my_workbook = new XSSFWorkbook();
           my_sheet = my_workbook.createSheet("MyLogo");
        } else {
            my_workbook = new XSSFWorkbook(new FileInputStream(excelPath));
            my_sheet = my_workbook.getSheet("MyLogo");
        }
    }

    public static XSSFClientAnchor getAnchorPoint() {
        System.out.println("Row is "+row);
        XSSFClientAnchor my_anchor = new XSSFClientAnchor();
        my_anchor.setCol1(2);
        my_anchor.setRow1(row);
        row = row + 5;
        return my_anchor;
    }

    public static void fileClose() throws IOException {
        FileOutputStream fos = new FileOutputStream(excelPath);
        my_workbook.write(fos);
        fos.close();
    }
}