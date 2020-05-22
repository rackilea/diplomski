import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InsertCurrentDateAndTimeInDocxUsingApachePOI {

    public static void main(String[] args) throws IOException {

        XWPFDocument  document  = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun       run       = paragraph.createRun();

        run.setText("Current date:");
        insertCurrentDateField(paragraph);

        run = paragraph.createRun();
        run.setText(" current time:");
        insertCurrentTimeField(paragraph);

        FileOutputStream out = new FileOutputStream(new File("CurrentDateAndTime.docx"));
        document.write(out);
    }

    private static void insertCurrentDateField(XWPFParagraph paragraph){
        XWPFRun run = paragraph.createRun(); 
        paragraph.getCTP().addNewFldSimple().setInstr("DATE \\@ \"yyyy-MM-dd\" \\* MERGEFORMAT");
    }
    private static void insertCurrentTimeField(XWPFParagraph paragraph){
        XWPFRun run = paragraph.createRun();
        paragraph.getCTP().addNewFldSimple().setInstr("TIME \\@ \"HH:mm:ss\" \\* MERGEFORMAT");
    }

}