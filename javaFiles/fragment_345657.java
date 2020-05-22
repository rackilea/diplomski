import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

public class WordRemoveCoverPage {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("WordDocumentWithCoverPage.docx"));

  if(document.getBodyElements().get(0) instanceof XWPFSDT) {
   System.out.println(document.removeBodyElement(0)); // true == success, but low level <w:sdt> is not removed from the XML
   document.getDocument().getBody().removeSdt(0);
  }

  document.write(new FileOutputStream("WordDocumentWithoutCoverPage.docx"));

  document.close();
 }
}