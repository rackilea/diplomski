import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.VerticalAlign;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ApachePOI {    
    public static void main(String[] args) {

    XWPFDocument document = new XWPFDocument(); 
    XWPFParagraph paragraphOne = document.createParagraph();

    paragraphOne.setAlignment(ParagraphAlignment.CENTER);

    XWPFRun paragraphOneRunOne = paragraphOne.createRun();
    paragraphOneRunOne.setFontSize(25);
    paragraphOneRunOne.setBold(true);
    paragraphOneRunOne.setText("Oxygene - O");

    XWPFRun paragraphOneRunTwo = paragraphOne.createRun();
    paragraphOneRunTwo.setFontSize(17);
    paragraphOneRunTwo.setBold(true);
    paragraphOneRunTwo.setSubscript(VerticalAlign.SUBSCRIPT);
    paragraphOneRunTwo.setText("2");

    try {
        FileOutputStream fos = new FileOutputStream("C://test.docx");
        document.write(fos);
        fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}