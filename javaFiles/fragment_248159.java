import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.*;

public class GuiDemo extends JPanel {

   // or better -- use an enum for this
   public static final String[] FIELD_LABELS = {
      "Pendulum Length", "Angular Displacement", "Angular Velocity",
      "Time Steps", "Max Time", "Viscocity (0-1)"
   };
   private static final int TEXT_FIELD_COLUMNS = 10;
   private static final int GAP = 3;
   private static final Insets RIGHT_GAP_INSETS = new Insets(GAP, GAP, GAP, 3 * GAP);
   private static final Insets BALANCED_INSETS = new Insets(GAP, GAP, GAP, GAP);
   private Map<String, JTextField> labelFieldMap = new HashMap<>();

   public GuiDemo() {
      JPanel labelFieldPanel = new JPanel(new GridBagLayout());
      int row = 0;

      // to make sure that no focusAccelerator is re-used
      Set<Character> focusAccelSet = new HashSet<>();
      for (String fieldLabelLText : FIELD_LABELS) {
         JLabel fieldLabel = new JLabel(fieldLabelLText);
         JTextField textField = new JTextField(TEXT_FIELD_COLUMNS);
         labelFieldPanel.add(fieldLabel, getGbc(row, 0));
         labelFieldPanel.add(textField, getGbc(row, 1));
         labelFieldMap.put(fieldLabelLText, textField);

         for (char c : fieldLabelLText.toCharArray()) {
            if (!focusAccelSet.contains(c)) {
               textField.setFocusAccelerator(c);
               fieldLabel.setDisplayedMnemonic(c);
               focusAccelSet.add(c);
               break;
            }
         }

         row++;
      }
      JButton button = new JButton(new DrawGraphAction("Draw New Graph"));

      labelFieldPanel.add(button, getGbc(row, 0, 2, 1));

      setLayout(new BorderLayout(GAP, GAP));
      add(labelFieldPanel, BorderLayout.CENTER);
   }

   private class DrawGraphAction extends AbstractAction {
      public DrawGraphAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO calculation method

      }
   }

   public static GridBagConstraints getGbc(int row, int column) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = column;
      gbc.gridy = row;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      if (column == 0) {
         gbc.anchor = GridBagConstraints.LINE_START;
         gbc.fill = GridBagConstraints.BOTH;
         gbc.insets = RIGHT_GAP_INSETS;
      } else {
         gbc.anchor = GridBagConstraints.LINE_END;
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.insets = BALANCED_INSETS;
      }

      return gbc;
   }

   public static GridBagConstraints getGbc(int row, int column, int width, int height) {
      GridBagConstraints gbc = getGbc(row, column);
      gbc.gridwidth = width;
      gbc.gridheight = height;
      gbc.insets = BALANCED_INSETS;
      gbc.fill = GridBagConstraints.BOTH;
      return gbc;
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Gui Demo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new GuiDemo());
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