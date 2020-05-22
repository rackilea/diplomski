import javax.swing.JTextArea;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.BadLocationException;

public static void setTextInLineNo(JTextArea textArea, int lineNo, String newText) {
     Document doc = textArea.getDocument();
     Element root = doc.getDefaultRootElement();
     Element contentEl = root.getElement(lineNo - 1);

     int start = contentEl.getStartOffset();
     int end = contentEl.getEndOffset();

     try {
         // remove words in the line (-1 to prevent removing newline character)
         doc.remove(start, end - start - 1);
         doc.insertString(start, newText, null);
     } catch (BadLocationException e) {
         e.printStackTrace();
     }
}