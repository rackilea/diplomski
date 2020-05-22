import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

public class GetLineFromTextArea {
   private static final int MIN_CHARS = 4;
   private static final int MAX_CHARS = 8;
   private static final int WORDS_PER_LINE = 10;
   private static final int ROWS = 30;

   public static void main(String[] args) {
      Random random = new Random();
      final JTextArea textArea = new JTextArea(20, 50);
      JScrollPane scrollpane = new JScrollPane(textArea);
      StringBuilder sb = new StringBuilder();

      for (int row = 0; row < ROWS ; row++) {
         sb = new StringBuilder();
         for (int words = 0; words < WORDS_PER_LINE; words++) {
            int maxChars = random.nextInt(MAX_CHARS - MIN_CHARS) + MIN_CHARS;
            for (int charsPerWord = 0; charsPerWord < maxChars; charsPerWord++) {
               char c = (char) (random.nextInt('z' - 'a' + 1) + 'a');
               sb.append(c);
            }
            sb.append(" ");
         }
         textArea.append(sb.toString() + "\n");
      }

      textArea.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
               return;
            }
            if (e.getClickCount() != 2) {
               return;
            }

            int offset = textArea.viewToModel(e.getPoint());

            try {
               int rowStart = Utilities.getRowStart(textArea, offset);
               int rowEnd = Utilities.getRowEnd(textArea, offset);
               String selectedLine = textArea.getText().substring(rowStart, rowEnd);
               System.out.println(selectedLine);

            } catch (BadLocationException e1) {
               e1.printStackTrace();
            }

         }
      });


      JOptionPane.showMessageDialog(null, scrollpane);
   }
}