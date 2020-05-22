import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Main {

    static String[] lines;

    public static void main(String[] args) throws Exception {
        PDDocument document = PDDocument.load(new File("my2.pdf"));
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        lines = text.split(System.getProperty("line.separator"));
        document.close();
    }
}