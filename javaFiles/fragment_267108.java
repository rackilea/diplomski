import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class FooGui2 {
   private static void createAndShowGui() {
      DataPanel dataPanel = new DataPanel();
      dataPanel.setEnabled(false);
      dataPanel.setId("10x");
      dataPanel.setName("Mickey Mouse");
      dataPanel.setEmail("MMouse@GMail.com");
      dataPanel.setCall(false);
      dataPanel.setPhone("555-111-1212");
      JPanel buttonPanel = new JPanel();
      buttonPanel.add(new JButton(new UpdateDataAction(dataPanel, "Update",
            KeyEvent.VK_U)));

      JFrame frame = new JFrame("Parent GUI");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.add(dataPanel.getMainPanel(), BorderLayout.CENTER);
      frame.add(buttonPanel, BorderLayout.SOUTH);
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

class UpdateDataAction extends AbstractAction {
   private DataPanel parentDataPanel;
   private DataPanel childDataPanel;

   public UpdateDataAction(DataPanel dataPanel, String name, int mnemonic) {
      super(name);
      putValue(MNEMONIC_KEY, mnemonic);
      this.parentDataPanel = dataPanel;
   }

   @Override
   public void actionPerformed(ActionEvent evt) {
      if (childDataPanel == null) {
         childDataPanel = new DataPanel();
      }

      childDataPanel.setId(parentDataPanel.getId());
      childDataPanel.setName(parentDataPanel.getName());
      childDataPanel.setEmail(parentDataPanel.getEmail());
      childDataPanel.setCall(parentDataPanel.isCall());
      childDataPanel.setPhone(parentDataPanel.getPhone());

      int result = JOptionPane.showConfirmDialog(
            parentDataPanel.getMainPanel(), childDataPanel.getMainPanel(),
            "Update Information JOptionPane", JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE);

      if (result == JOptionPane.OK_OPTION) {
         // !! if opted to change the parent data, then do it!
         parentDataPanel.setId(childDataPanel.getId());
         parentDataPanel.setName(childDataPanel.getName());
         parentDataPanel.setEmail(childDataPanel.getEmail());
         parentDataPanel.setCall(childDataPanel.isCall());
         parentDataPanel.setPhone(childDataPanel.getPhone());
      }
   }
}

class DataPanel {
   private static final int I_GAP = 5;
   private static final Insets INSETS = new Insets(I_GAP, I_GAP, I_GAP, I_GAP);
   private JPanel mainPanel = new JPanel();
   private JTextField idField = new JTextField(4);
   private JTextField nameField = new JTextField(10);
   private JTextField emailField = new JTextField(15);
   private JCheckBox callCheckBox = new JCheckBox();
   private JTextField phoneField = new JTextField(15);
   private JComponent[] components = { idField, nameField, emailField,
         callCheckBox, phoneField };

   public DataPanel() {
      mainPanel.setLayout(new GridBagLayout());
      addLabelComponent("ID", idField, 0, -1f);
      addLabelComponent("Name", nameField, 1, -1f);
      addLabelComponent("EMail", emailField, 2, -1f);
      addLabelComponent("Call", callCheckBox, 3, -1f);
      addLabelComponent("Phone", phoneField, 4, -1f);
   }

   private void addLabelComponent(String labelText, JComponent jComp,
         int xPosition, float labelPoints) {
      JLabel label = new JLabel(labelText, SwingConstants.CENTER);
      if (labelPoints > 0) {
         label.setFont(label.getFont().deriveFont(labelPoints));
      }
      // label position
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = xPosition;
      gbc.gridy = 0;
      gbc.anchor = GridBagConstraints.CENTER;
      gbc.fill = GridBagConstraints.BOTH;
      gbc.gridheight = 1;
      gbc.gridwidth = 1;
      gbc.weightx = 1.0;
      gbc.weighty = 1.0;
      gbc.insets = INSETS;
      mainPanel.add(label, gbc);

      // component position
      gbc.gridy = 1;
      gbc.fill = GridBagConstraints.NONE;
      mainPanel.add(jComp, gbc);
   }

   public void setId(String id) {
      idField.setText(id);
   }

   public String getId() {
      return idField.getText();
   }

   public void setName(String name) {
      nameField.setText(name);
   }

   public String getName() {
      return nameField.getText();
   }

   public void setEmail(String email) {
      emailField.setText(email);
   }

   public String getEmail() {
      return emailField.getText();
   }

   public void setCall(boolean call) {
      callCheckBox.setSelected(call);
   }

   public boolean isCall() {
      return callCheckBox.isSelected();
   }

   public void setPhone(String phone) {
      phoneField.setText(phone);
   }

   public String getPhone() {
      return phoneField.getText();
   }

   public void setEnabled(boolean enabled) {
      mainPanel.setEnabled(enabled);
      for (JComponent component : components) {
         component.setFocusable(false);
         component.setEnabled(false);
      }
   }

   public JComponent getMainPanel() {
      return mainPanel;
   }

}