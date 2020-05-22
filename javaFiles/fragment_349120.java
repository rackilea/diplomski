import java.awt.event.ActionEvent;
import javax.swing.*;

public class Mcve extends JPanel {
   private static final String[] DATA = {"One", "Two", "Three", "Four", "Five"};

   private DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<>();
   private JComboBox<String> comboBox = new JComboBox<>(comboModel);

   private DefaultListModel<String> listModel = new DefaultListModel<>();
   private JList<String> list = new JList<>(listModel);

   public Mcve() {
      list.setPrototypeCellValue(String.format("%30s", " "));
      list.setVisibleRowCount(10);;

      // fill combo box's model with a bunch of junk
      for (int i = 0; i < 10; i++) {
         for (int j = 0; j < DATA.length; j++) {
            String text = DATA[j] + " " + i;
            comboModel.addElement(text);
         }
      }

      Action buttonAction = new ButtonAction("Transfer Data");
      comboBox.addActionListener(buttonAction);

      add(comboBox);
      add(new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
      add(new JButton(buttonAction));
   }

   private class ButtonAction extends AbstractAction {
      public ButtonAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         Object selection = comboBox.getSelectedItem();
         if (selection != null) {
            listModel.addElement(selection.toString());
         }
      }
   }

   private static void createAndShowGui() {
      Mcve mainPanel = new Mcve();

      JFrame frame = new JFrame("Mcve");
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