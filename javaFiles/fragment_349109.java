import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxTest extends JPanel implements ItemListener {
   private static final int PREF_W = 300;
   private static final int PREF_H = PREF_W;
   final String[] sizes = { "10%", "20%", "33%" };
   JComboBox combobox = new JComboBox(sizes);
   int selectedIndex;
   private double scaleFactor = 1;

   public ComboBoxTest() {
      setLayout(new GridBagLayout());
      combobox.setSelectedIndex(-1);
      combobox.addItemListener(this);
      GridBagConstraints comboBoxConstraints = new GridBagConstraints();
      comboBoxConstraints.gridx = 0;
      comboBoxConstraints.gridy = 0;
      comboBoxConstraints.gridwidth = 1;
      comboBoxConstraints.gridheight = 1;
      comboBoxConstraints.fill = GridBagConstraints.NONE;
      add(combobox, comboBoxConstraints);// This should be placed at top, in
                                         // middle.

      GridBagConstraints displayConstraints = new GridBagConstraints();
      displayConstraints.gridx = 0;
      displayConstraints.gridy = 1;
      displayConstraints.gridwidth = 1;
      displayConstraints.gridheight = 1;
      displayConstraints.fill = GridBagConstraints.BOTH;
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public void itemStateChanged(ItemEvent e) {
      if (e.getStateChange() == ItemEvent.SELECTED) {
         JComboBox combo = (JComboBox) e.getSource();
         selectedIndex = combo.getSelectedIndex();
         System.out.println("selectedIndex is: " + selectedIndex);
         if (selectedIndex == -1) {
            return;
         }
         String selectedItem = combo.getSelectedItem().toString().trim();
         selectedItem = selectedItem.replace("%", "");
         scaleFactor = Double.parseDouble(selectedItem) / 100.0;
         repaint();
      }
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
         int xStart = (getWidth() / 2) - (int)(getWidth() * scaleFactor);
         int yStart = (getHeight() / 2) - (int)(getHeight() * scaleFactor);
         g.drawRect(xStart, yStart, (int)(getWidth() * scaleFactor),
               (int)(getHeight() * scaleFactor));
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("ComboBoxTest");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new ComboBoxTest());
      frame.pack();
      frame.setLocationRelativeTo(null);
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