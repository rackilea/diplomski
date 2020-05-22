import java.awt.Color;
import java.io.*;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;

public class XlsColors {

    static String fileName = "TestWorkbook.xlsx";

    public static void main(String[] args) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sht = wb.createSheet();
        File file = new File(fileName);
        int colStart = 5;

        XSSFDrawing draw = sht.createDrawingPatriarch();

        XSSFShapeGroup group = draw.createGroup(draw.createAnchor(0, 0, 0, 0, colStart, 11, colStart + 6, 11+7));
        group.setCoordinates(colStart, 11, colStart + 6, 11+7);

        XSSFTextBox tb1 = group.createTextbox(new XSSFChildAnchor(0, 0, 6, 7));
        tb1.setLineStyleColor(0, 0, 0);
        tb1.setLineWidth(2);
        Color col = Color.orange;
        tb1.setFillColor(col.getRed(), col.getGreen(), col.getBlue());

        XSSFRichTextString address = new XSSFRichTextString("TextBox string 1\nHas three\nLines to it");
        tb1.setText(address);        
        CTTextCharacterProperties rpr = tb1.getCTShape().getTxBody().getPArray(0).getRArray(0).getRPr();
        rpr.addNewLatin().setTypeface("Trebuchet MS");
        rpr.setSz(900); // 9 pt
        col = Color.pink;
        rpr.addNewSolidFill().addNewSrgbClr().setVal(new byte[]{(byte)col.getRed(),(byte)col.getGreen(),(byte)col.getBlue()});

        FileOutputStream fout = new FileOutputStream(file);
        wb.write(fout);
        fout.close();
    }
}