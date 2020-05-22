import java.awt.*;
import javax.swing.*;

public class BoxLayoutEg {
   public static void main(String[] args) {
      JTextArea area1 = new JTextArea(10, 20);
      JToggleButton toggleBtn = new JToggleButton("Foo");
      JTextArea area2 = new JTextArea(10, 20);

      JPanel toggleBtnPanel = new JPanel();
      toggleBtnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
      // toggleBtnPanel.setLayout(new GridLayout());
      toggleBtnPanel.add(toggleBtn);

      JPanel mainJPanel = new JPanel();
      mainJPanel.setLayout(new BoxLayout(mainJPanel, BoxLayout.PAGE_AXIS));

      mainJPanel.add(new JScrollPane(area1));
      mainJPanel.add(toggleBtnPanel);
      mainJPanel.add(new JScrollPane(area2));

      JOptionPane.showMessageDialog(null, mainJPanel);

   }
}