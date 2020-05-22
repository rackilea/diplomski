import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Component;

public class NewLoginBox extends JDialog {
   private static final long serialVersionUID = 1L;
   private final JPanel contentPanel = new JPanel();
   private JTextField userID;
   private JPasswordField passwordField;

   public static void main(String[] args) {
      try {
         NewLoginBox dialog = new NewLoginBox();
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.pack();
         dialog.setLocationRelativeTo(null);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public NewLoginBox() {
      //setBounds(100, 100, 350, 220);
      // getContentPane().setLayout(new BorderLayout());
      TitledBorder titledBorder = new TitledBorder(null, "Sign In",
            TitledBorder.LEADING, TitledBorder.TOP, null, null);
      int ebGap = 10;
      EmptyBorder emptyBorder = new EmptyBorder(ebGap, ebGap, ebGap, ebGap);
      Border compoundBorder = new CompoundBorder(titledBorder, emptyBorder);
      contentPanel.setBorder(compoundBorder );
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
      JPanel titlePanel = new JPanel();
      contentPanel.add(titlePanel);
      titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.Y_AXIS));
      JLabel lblPleaseEnterYour = new JLabel(
            "Welcome to Application. Please Sign In ");
      lblPleaseEnterYour.setAlignmentX(Component.CENTER_ALIGNMENT);
      lblPleaseEnterYour.setAlignmentY(Component.BOTTOM_ALIGNMENT);
      lblPleaseEnterYour.setHorizontalAlignment(SwingConstants.LEFT);
      titlePanel.add(lblPleaseEnterYour);
      titlePanel.add(Box.createVerticalStrut(15));

      JPanel formPanel = new JPanel();
      contentPanel.add(formPanel);

      // formPanel.setLayout(new GridLayout(0, 2, 5, 5));
      ebGap = 7;
      formPanel.setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));
      formPanel.setLayout(new GridBagLayout());
      JLabel lblUserId = new JLabel("User ID");
      addWithGbc(formPanel, lblUserId, 0, 0);
      userID = new JTextField("", 15);
      addWithGbc(formPanel, userID, 1, 0);
      userID.setColumns(10);
      JLabel lblPassword = new JLabel("Password");
      addWithGbc(formPanel, lblPassword, 0, 1);
      passwordField = new JPasswordField();
      addWithGbc(formPanel, passwordField, 1, 1);
      JPanel buttonPane = new JPanel();
      buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      getContentPane().add(buttonPane, BorderLayout.SOUTH);
      JButton okButton = new JButton("OK");
      okButton.setActionCommand("OK");
      buttonPane.add(okButton);
      getRootPane().setDefaultButton(okButton);
      JButton cancelButton = new JButton("Cancel");
      cancelButton.setActionCommand("Cancel");
      buttonPane.add(cancelButton);
      JButton btnHelp = new JButton("Help");
      buttonPane.add(btnHelp);
   }

   private void addWithGbc(Container container, JComponent component, int x,
         int y) {
      int hGap = 5;

      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      if (x % 2 == 0) {
         gbc.anchor = GridBagConstraints.WEST;
         gbc.insets = new Insets(hGap, 0, hGap, 20); // magic number!
         gbc.weightx = 1.0;
         gbc.weighty = 1.0;
         gbc.fill = GridBagConstraints.BOTH;
      } else {
         gbc.anchor = GridBagConstraints.EAST;
         gbc.insets = new Insets(hGap, 0, hGap, 0);
         gbc.weightx = 1.0;
         gbc.weighty = 0.0;
         gbc.fill = GridBagConstraints.HORIZONTAL;
      }
      container.add(component, gbc);
   }
}