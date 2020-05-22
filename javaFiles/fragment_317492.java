import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Foo002 {

   private static final int ROWS = 5;

   private static void createAndShowGui() {
      JPanel assignmentsPanel = new JPanel(new GridBagLayout());
      final JTextArea textarea = new JTextArea(ROWS, 20);

      GridBagConstraints c = new GridBagConstraints();
      int insetGap = 2;
      c.insets = new Insets(insetGap, insetGap, insetGap, insetGap);
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      String[] labels = { "title", "author", "date due", "date set",
            "set weighting" };
      int row = 0;
      for (int i = 0; i < labels.length; i++) {
         JLabel label = new JLabel(labels[i], SwingConstants.CENTER);
         c.gridx = 0;
         c.gridy = i;
         assignmentsPanel.add(label, c);
         c.gridx = 1;
         JTextField textfield = new JTextField(10);
         assignmentsPanel.add(textfield, c);

         label.setPreferredSize(textfield.getPreferredSize());
         row++;
      }
      c.gridx = 0;
      c.gridy = row;
      c.fill = GridBagConstraints.HORIZONTAL;
      Action myAction = new AbstractAction("Fill Area") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
               sb.append("foo bar bif baz spam\n");
            }
            textarea.setText(sb.toString());
         }
      };
      assignmentsPanel.add(new JButton(myAction), c);
      c.gridx = 1;
      assignmentsPanel.add(new JButton("Button 2"), c);
      row++;

      c.gridx = 0;
      c.gridy = row;
      c.gridwidth = 2;
      c.gridheight = ROWS;

      JScrollPane scrollpane = new JScrollPane(textarea);

      assignmentsPanel.add(scrollpane, c);

      JTabbedPane tabbedPanel = new JTabbedPane();
      tabbedPanel.add("Assignments", assignmentsPanel);
      tabbedPanel.add("Modules", new JPanel());

      JOptionPane.showMessageDialog(null, tabbedPanel, "Foo",
            JOptionPane.PLAIN_MESSAGE);

   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}