import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlCursor;

import  org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;

import java.util.List;
import java.util.ArrayList;

public class WordReplaceTextInTextBox {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("WordReplaceTextInTextBox.docx"));

  String someWords = "TextBox";

  for (XWPFParagraph paragraph : document.getParagraphs()) {
   XmlCursor cursor = paragraph.getCTP().newCursor();
   cursor.selectPath("declare namespace w='http://schemas.openxmlformats.org/wordprocessingml/2006/main' .//*/w:txbxContent/w:p/w:r");

   List<XmlObject> ctrsintxtbx = new ArrayList<XmlObject>();

   while(cursor.hasNextSelection()) {
    cursor.toNextSelection();
    XmlObject obj = cursor.getObject();
    ctrsintxtbx.add(obj);
   }
   for (XmlObject obj : ctrsintxtbx) {
    CTR ctr = CTR.Factory.parse(obj.xmlText());
    //CTR ctr = CTR.Factory.parse(obj.newInputStream());
    XWPFRun bufferrun = new XWPFRun(ctr, (IRunBody)paragraph);
    String text = bufferrun.getText(0);
    if (text != null && text.contains(someWords)) {
     text = text.replace(someWords, "replaced");
     bufferrun.setText(text, 0);
    }
    obj.set(bufferrun.getCTR());
   }
  }

  FileOutputStream out = new FileOutputStream("WordReplaceTextInTextBoxNew.docx");
  document.write(out);
  out.close();
  document.close();
 }
}