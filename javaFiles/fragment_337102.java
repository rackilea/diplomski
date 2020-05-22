import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.ArabicShapingException;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.*;

public class Main {
    public static void main(String[] args) throws IOException , ArabicShapingException
{
        File f = new File("Arabic Font File of format.ttf");
        PDDocument doc = new PDDocument();
        PDPage Page = new PDPage();
        doc.addPage(Page);
        PDPageContentStream Writer = new PDPageContentStream(doc, Page);
        Writer.beginText();
        Writer.setFont(PDType0Font.load(doc, f), 20);
        Writer.newLineAtOffset(0, 700);
        //The Trick in the next Line of Code But Here is some few Notes first  
        //We have to reverse the string because PDFBox is Writting from the left but Arabic is RTL Language  
        //The output will be perfect except every line will be justified to the left "It's not hard to resolve this"
        // So we have to write arabic string to pdf line by line..It will be like this
        String s ="جملة بالعربي لتجربة الكلاس اللذي يساعد علي وصل الحروف بشكل صحيح";
        Writer.showText(new StringBuilder(new ArabicShaping(reverseNumbersInString(ArabicShaping.LETTERS_SHAPE).shape(s))).reverse().toString());
        // Note the previous line of code throws ArabicShapingExcpetion 
        Writer.endText();
        Writer.close();
        doc.save(new File("File_Test.pdf"));
        doc.close();
    }
}