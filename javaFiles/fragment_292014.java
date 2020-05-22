import java.awt.Dimension;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

public class ScrollPaneFun {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            Random rand = new Random();
            DefaultListModel<String> lModel = new DefaultListModel<>();
            JList<String> myList = new JList<>(lModel);
            myList.setVisibleRowCount(20);

            for (int i = 0; i < 50; i++) {
               StringBuilder sb = new StringBuilder();
               sb.append(String.valueOf(i) + ": ");
               for (int j = 0; j < 50; j++) {
                  for (int k = 0; k < 3; k++) {
                     char c = (char) ('a' + rand.nextInt('z' - 'a' + 1));
                     sb.append(c);
                  }
                  sb.append(' ');
               }
               lModel.addElement(sb.toString());
            }

            JScrollPane scrollPane = new JScrollPane(myList);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            JViewport viewport = scrollPane.getViewport();
            int w = 400;
            int h = viewport.getPreferredSize().height;
            Dimension preferredSize = new Dimension(w, h);
            viewport.setPreferredSize(preferredSize);
            JOptionPane.showMessageDialog(null, scrollPane);
         }
      });
   }
}