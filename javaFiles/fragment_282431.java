import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

@SuppressWarnings("serial")
public class LabelsAndFields {
   public static final String[] LABEL_TEXTS = {
      "Sunday", "Monday", "Tuesday",
      "Wednesday", "Thursday", "Friday", "Saturday"};

   private JPanel mainPanel = new JPanel();
   private static final int FIELD_COLS = 10;
   private Map<String, JTextField> textFieldMap = new HashMap<String, JTextField>();

   public LabelsAndFields() {
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
      for (String labelText : LABEL_TEXTS) {
         JTextField textField = new JTextField(FIELD_COLS);
         textFieldMap.put(labelText, textField);
         JPanel panel = new JPanel(new BorderLayout());
         panel.add(new JLabel(labelText), BorderLayout.NORTH);
         panel.add(textField);
         int gap = 8;
         panel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
         mainPanel.add(panel);
      }
   }

   public String getText(String labelTextKey) {
      JTextField field = textFieldMap.get(labelTextKey);
      if (field == null) {
         throw new IllegalArgumentException(labelTextKey + "is not a valid textFieldMap Key");
      }

      return field.getText();
   }

   public void setText(String labelTextKey, String text) {
      JTextField field = textFieldMap.get(labelTextKey);
      if (field == null) {
         throw new IllegalArgumentException(labelTextKey + "is not a valid textFieldMap Key");
      }

      field.setText(text);
   }

   public JPanel getMainPanel() {
      return mainPanel;
   }

   private static void createAndShowUI() {
      final LabelsAndFields labelsAndFields = new LabelsAndFields();

      JButton showAllTextBtn = new JButton(new AbstractAction("Show All Text") {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            for (String labelText : LabelsAndFields.LABEL_TEXTS) {
               System.out.printf("%10s: %s%n", labelText, labelsAndFields.getText(labelText));
            }
         }
      });

      JFrame frame = new JFrame("LabelsAndFields");
      frame.getContentPane().add(labelsAndFields.getMainPanel(), BorderLayout.CENTER);
      frame.getContentPane().add(showAllTextBtn, BorderLayout.SOUTH);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}