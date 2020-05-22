package utftext;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

public class utftext {

    public static void main(String[] args) throws Exception {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
        PDType0Font font = PDType0Font.load(document, new File("E:\\arialuni.ttf"));
        PDPageContentStream stream = new PDPageContentStream(document, page);
        String text = "ssdfg #$%&&English 012 čćžšđ ČĆŽŠĐ as äöüÖÜÄ";
        stream.beginText();
        stream.setFont(font, 12);
        stream.moveTextPositionByAmount(50, 600);
        stream.drawString(text);
        stream.endText();
        stream.close();
        document.save("type0.pdf");
        document.close();
    }

}