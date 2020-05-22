import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
...
PDDocument doc = PDDocument.load(file);
PDFTextStripper textStripper = new PDFTextStripper();
// textStripper.setSortByPosition(true);
String text = textStripper.getText(doc);