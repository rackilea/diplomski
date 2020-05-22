import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class DocListenerEg extends JPanel {
   private static final int FIELD_COUNT = 15;
   private static final int COLS = 6;
   private List<JTextField> fieldList = new ArrayList<>();
   private JTextField sumField = new JTextField(COLS);

   public DocListenerEg() {
      sumField.setFocusable(false);

      DocListener docListener = new DocListener();
      DocFilter docFilter = new DocFilter();
      for (int i = 0; i < FIELD_COUNT; i++) {
         JTextField textField = new JTextField(COLS);
         Document doc = textField.getDocument();
         doc.addDocumentListener(docListener);
         ((PlainDocument) doc).setDocumentFilter(docFilter);
         add(textField);
         fieldList.add(textField);
         String labelText = i < (FIELD_COUNT - 1) ? "+" : "=";
         add(new JLabel(labelText));
      }
      add(sumField);
   }

   private class DocFilter extends DocumentFilter {
      private boolean checkIfIntegerOrEmpty(String text) {
         if (text.isEmpty()) {
            return true;
         } else {
            try {
               Integer.parseInt(text);
               return true;
            } catch (NumberFormatException e) {
            }
         }
         return false;
      }

      @Override
      public void insertString(FilterBypass fb, int offset, String string,
            AttributeSet attr) throws BadLocationException {
         Document doc = fb.getDocument();
         String preText = doc.getText(0, doc.getLength());

         StringBuilder sb = new StringBuilder(preText);
         sb.insert(offset, string);

         if (checkIfIntegerOrEmpty(sb.toString())) {
            super.insertString(fb, offset, string, attr);
         }

      }

      @Override
      public void remove(FilterBypass fb, int offset, int length)
            throws BadLocationException {
         Document doc = fb.getDocument();
         String preText = doc.getText(0, doc.getLength());

         StringBuilder sb = new StringBuilder(preText);
         int end = offset + length;
         sb.replace(offset, end, "");

         if (checkIfIntegerOrEmpty(sb.toString())) {            
            super.remove(fb, offset, length);
         }
      }

      @Override
      public void replace(FilterBypass fb, int offset, int length, String text,
            AttributeSet attrs) throws BadLocationException {
         Document doc = fb.getDocument();
         String preText = doc.getText(0, doc.getLength());

         StringBuilder sb = new StringBuilder(preText);
         int end = offset + length;
         sb.replace(offset, end, text);

         if (checkIfIntegerOrEmpty(sb.toString())) {            
            super.replace(fb, offset, length, text, attrs);
         }
      }
   }

   private class DocListener implements DocumentListener {

      private void textChanged() {
         int sum = 0;
         for (JTextField jTextField : fieldList) {
            String text = jTextField.getText().trim();
            if (!text.isEmpty()) {
               sum += Integer.parseInt(text);
            }
         }
         sumField.setText(String.valueOf(sum));
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
         textChanged();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
         textChanged();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
         textChanged();
      }

   }

   private static void createAndShowGui() {
      DocListenerEg mainPanel = new DocListenerEg();

      JFrame frame = new JFrame("DocListenerEg");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}