import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class TextEditor {

   public static void main(String[] args) {
      JFrame f = new JFrame("Foo");
      f.add(Box.createRigidArea(new Dimension(700, 500)));
      JMenuBar menuBar = new JMenuBar();
      f.setJMenuBar(menuBar);
      JMenu file = new JMenu("File");
      file.setMnemonic(KeyEvent.VK_F);
      menuBar.add(file);
      JMenuItem open = new JMenuItem("Open File");
      file.add(open);

      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      f.pack();
      f.setVisible(true);
   }
}