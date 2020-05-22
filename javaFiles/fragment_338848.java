import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

//needed jars: fr.opensagres.poi.xwpf.converter.core-2.0.2.jar, 
//             fr.opensagres.poi.xwpf.converter.pdf-2.0.2.jar,
//             fr.opensagres.xdocreport.itext.extension-2.0.2.jar,
//             itext-4.2.1.jar                                  
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;

//needed jars: apache poi and it's dependencies
//inclusive    ooxml-schemas-1.4.jar
import org.apache.poi.xwpf.usermodel.*;

public class DOCXToPDFConverterSampleMin {

 public static void main(String[] args) throws Exception {

  String docPath = "./WordDocument.docx";
  String pdfPath = "./WordDocument.pdf";

  InputStream in = new FileInputStream(new File(docPath));
  XWPFDocument document = new XWPFDocument(in);

  for (XWPFParagraph paragraph : document.getParagraphs()) {
   for (XWPFRun run : paragraph.getRuns()) {
    String text = run.getText(0);
    if (text != null && text.contains("$name$")) {
     text = text.replace("$name$", "Axel Richter");
     run.setText(text, 0);
    } else if (text != null && text.contains("$date$")) {
     text = text.replace("$date$", "2019-02-28");
     run.setText(text, 0);
    }
   }
  }
  for (XWPFTable table : document.getTables()) {
   for (XWPFTableRow row : table.getRows()) {
    for (XWPFTableCell cell : row.getTableCells()) {
     for (XWPFParagraph paragraph : cell.getParagraphs()) {
      for (XWPFRun run : paragraph.getRuns()) {
       String text = run.getText(0);
       if (text != null && text.contains("$name$")) {
        text = text.replace("$name$", "Axel Richter");
        run.setText(text,0);
       } else if (text != null && text.contains("$date$")) {
        text = text.replace("$date$", "2019-02-28");
        run.setText(text, 0);
       }
      }
     }
    }
   }
  }

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run = paragraph.createRun();
  run.setText("This is new Text in this document.");

  PdfOptions options = PdfOptions.create();
  OutputStream out = new FileOutputStream(new File(pdfPath));
  PdfConverter.getInstance().convert(document, out, options);

  document.close();
  out.close();

 }
}