import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LinkedCombos extends JPanel {
   public static final String[] DATA = {"a", "b", "c"};
   public static final int COMBO_COUNT = 3;
   private DefaultComboBoxModel[] comboModels = new DefaultComboBoxModel[COMBO_COUNT];
   private NewComboBox[] comboBoxes = new NewComboBox[COMBO_COUNT];
   private MyComboListener myComboListener = new MyComboListener();

   public LinkedCombos() {
      for (int i = 0; i < comboModels.length; i++) {
         comboModels[i] = new DefaultComboBoxModel(DATA);
         comboBoxes[i] = new NewComboBox(comboModels[i]);
         comboBoxes[i].setSelectedIndex(i);
         comboBoxes[i].addActionListener(myComboListener);
         add(comboBoxes[i]);
      }
   }

   private class MyComboListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evt) {
         NewComboBox combo = (NewComboBox) evt.getSource();
         String selection = combo.getSelectedItem().toString();

         for (int i = 0; i < comboBoxes.length; i++) {
            NewComboBox comboI = comboBoxes[i];
            if (comboI != combo && comboI.getSelectedItem().equals(selection)) {
               comboI.setSelectedItem(combo.getPreviousSelectedItem());
            }
         }
      }
   }

   private static void createAndShowGui() {
      LinkedCombos mainPanel = new LinkedCombos();

      JFrame frame = new JFrame("LinkedCombos");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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