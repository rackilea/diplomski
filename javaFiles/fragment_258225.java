import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.SimpleValue;
import javax.xml.namespace.QName;

public class WordReplaceTextInFormFields {

 private static void replaceFormFieldText(XWPFDocument document, String ffname, String text) {
  boolean foundformfield = false;
  for (XWPFParagraph paragraph : document.getParagraphs()) {
   for (XWPFRun run : paragraph.getRuns()) {
    XmlCursor cursor = run.getCTR().newCursor();
    cursor.selectPath("declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main' .//w:fldChar/@w:fldCharType");
    while(cursor.hasNextSelection()) {
     cursor.toNextSelection();
     XmlObject obj = cursor.getObject();
     if ("begin".equals(((SimpleValue)obj).getStringValue())) {
      cursor.toParent();
      obj = cursor.getObject();
      obj = obj.selectPath("declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main' .//w:ffData/w:name/@w:val")[0];
      if (ffname.equals(((SimpleValue)obj).getStringValue())) {
       foundformfield = true;
      } else {
       foundformfield = false;
      }
     } else if ("end".equals(((SimpleValue)obj).getStringValue())) {
      if (foundformfield) return;
      foundformfield = false;
     }
    }
    if (foundformfield && run.getCTR().getTList().size() > 0) {
     run.getCTR().getTList().get(0).setStringValue(text);
//System.out.println(run.getCTR());
    }
   }
  }
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("WordTemplate.docx"));

  replaceFormFieldText(document, "Text1", "Mrs.");
  replaceFormFieldText(document, "Text2", "Janis");
  replaceFormFieldText(document, "Text3", "Lyn");
  replaceFormFieldText(document, "Text4", "Joplin");
  replaceFormFieldText(document, "Text5", "Mercedes Benz");
  replaceFormFieldText(document, "Text6", "1234-56-789");
  replaceFormFieldText(document, "Text7", "Stuttgart");

  FileOutputStream out = new FileOutputStream("WordReplaceTextInFormFields.docx");
  document.write(out);
  out.close();
  document.close();
 }
}