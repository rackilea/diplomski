import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class App8 extends JPanel {
   private static final int COMBO_COUNT = 2;
   private static final String SIGNAL = "Signal";
   private List<JComboBox<ComboColor>> comboList = new ArrayList<>();

   public App8() {
      setLayout(new GridLayout(0, 1));
      for (int i = 0; i < COMBO_COUNT; i++) {
         DefaultComboBoxModel<ComboColor> cModel = new DefaultComboBoxModel<>(ComboColor.values());
         JComboBox<ComboColor> combo = new JComboBox<>(cModel);
         add(createComboLabelPanel((i + 1), combo));
         comboList.add(combo);
      }
   }

   private JPanel createComboLabelPanel(int index, final JComboBox<ComboColor> combo) {
      JPanel panel = new JPanel();
      final JLabel label = new JLabel(SIGNAL + " " + index);
      label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      label.setOpaque(true);
      combo.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent evt) {
            ComboColor cColor = (ComboColor) combo.getSelectedItem();
            label.setBackground(cColor.getColor());
         }
      });

      panel.add(label);
      panel.add(combo);
      return panel;
   }

   private static void createAndShowGui() {
      App8 mainPanel = new App8();

      JFrame frame = new JFrame("App8");
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

enum ComboColor {
   RED("Red", Color.RED),
   GREEN("Green", Color.GREEN);

   private String text;
   private Color color;

   public String getText() {
      return text;
   }
   public Color getColor() {
      return color;
   }
   private ComboColor(String text, Color color) {
      this.text = text;
      this.color = color;
   }

   @Override
   public String toString() {
      return text;
   }
}