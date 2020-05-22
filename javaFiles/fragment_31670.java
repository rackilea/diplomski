import java.io.IOException;
import java.io.OutputStream;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class JListOutputStream extends OutputStream {
   private DefaultListModel logListModel;
   private StringBuilder sb = new StringBuilder();   

   public JListOutputStream(DefaultListModel logListModel) {
      this.logListModel = logListModel;
   }

   @Override
   public void write(int b) throws IOException {
      if (b == '\r')
         return;

      if (b == '\n') {
         final String text = sb.toString().trim();
         sb.setLength(0);
         if (text.isEmpty()) {
            return;
         }
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               logListModel.addElement(text);
            }
         });

         return;
      }

      sb.append((char) b);
   }

}