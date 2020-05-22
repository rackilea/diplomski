import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

// Avoid extending JFrames if at all possible.
// and only extend other components if needed.
@SuppressWarnings("serial")
public class TheSize2 extends JPanel {
   private static final String FORMAT = "*  2^ %s";
   private static final int PREF_W = 550;
   private static final int PREF_H = 100;
   private String inText = "";
   private JLabel word0 = new JLabel("I would like my grid to be 2^", JLabel.RIGHT);
   private JLabel word1 = new JLabel(String.format(FORMAT, inText), JLabel.RIGHT);
   private JButton finish = new JButton("I'm done");
   private JTextField size = new JTextField("", 3);

   public TheSize2() {
      finish.setAction(new FinishAction("I'm Done"));
      size.getDocument().addDocumentListener(new SizeListener());
      add(word0);
      add(size);
      add(word1);
      add(finish);
   }

   @Override // make JPanel bigger
   public Dimension getPreferredSize() {
      Dimension superSz = super.getPreferredSize();
      if (isPreferredSizeSet()) {
         return superSz;
      }
      int prefW = Math.max(superSz.width, PREF_W);
      int prefH = Math.max(superSz.height, PREF_H);
      return new Dimension(prefW, prefH);
   }

   private class SizeListener implements DocumentListener {
      private void textUpdated(DocumentEvent e) {
         try {
            inText = e.getDocument().getText(0, e.getDocument().getLength());
            word1.setText(String.format(FORMAT, inText));
         } catch (BadLocationException e1) {
            e1.printStackTrace();
         }
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
         textUpdated(e);
      }

      @Override
      public void insertUpdate(DocumentEvent e) {
         textUpdated(e);

      }

      @Override
      public void removeUpdate(DocumentEvent e) {
         textUpdated(e);
      }

   }

   private class FinishAction extends AbstractAction {
      public FinishAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         Component comp = (Component) e.getSource();
         if (comp == null) {
            return;
         }
         Window win = SwingUtilities.getWindowAncestor(comp);
         if (win == null) {
            return;
         }
         win.dispose();         
      }
   }

   private static void createAndShowGui() {
      TheSize2 theSize2 = new TheSize2();

      JFrame frame = new JFrame("The Size");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(theSize2);
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