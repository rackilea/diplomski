import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.text.JTextComponent;

@SuppressWarnings("serial")
// I try to gear my GUI's towards creation of JPanels, not JFrames
// I then can put the panel into a JFrame or into something else if desired
public class SimpleGui extends JPanel {
   private JTextField firstNameField = new JTextField(10);
   private JTextField lastNameField = new JTextField(10);
   private JTextComponent[] textComponents = {firstNameField, lastNameField};
   private DefaultListModel<SimpleDetails> detailsListModel = new DefaultListModel<>();
   private JList<SimpleDetails> detailsList = new JList<>(detailsListModel);

   public SimpleGui() {
      JPanel dataEntryPanel = new JPanel();
      dataEntryPanel.add(new JLabel("First Name:"));
      dataEntryPanel.add(firstNameField);
      dataEntryPanel.add(Box.createHorizontalStrut(15)); // add space
      dataEntryPanel.add(new JLabel("Last Name:"));
      dataEntryPanel.add(lastNameField);

      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
      buttonPanel.add(new JButton(new ClearAction("Clear", KeyEvent.VK_C)));
      buttonPanel.add(new JButton(new SubmitAction("Submit", KeyEvent.VK_S)));
      buttonPanel.add(new JButton(new ExitAction("Exit", KeyEvent.VK_X)));

      JPanel detailsPanel = new JPanel();
      detailsList.setPrototypeCellValue(new SimpleDetails("AAAAAAAAAAAA", "BBBBBBBBBBBB"));
      detailsList.setVisibleRowCount(12);
      JScrollPane detailsScrollPane = new JScrollPane(detailsList);
      detailsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      detailsPanel.add(detailsScrollPane);

      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      add(detailsPanel);
      add(dataEntryPanel);
      add(buttonPanel);
   }

   public void clearTextFields() {
      for (JTextComponent jTextComponent : textComponents) {
         jTextComponent.setText("");
      }
   }

   private class SubmitAction extends AbstractAction {
      public SubmitAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         String firstName = firstNameField.getText();
         String lastName = lastNameField.getText();

         // validate input here or after creating details object
         // if valid, then 

         // create your details object
         SimpleDetails simpleDetails = new SimpleDetails(firstName, lastName);

         if (Validate.test(simpleDetails)) {
            // and then DO something with it. 
            // Here I add it to a JList
            detailsListModel.addElement(simpleDetails);
         } else {
            // notify user that data is bad
            // consider clearing the GUI
            clearTextFields();
         }

      }
   }

   private class ClearAction extends AbstractAction {

      public ClearAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         clearTextFields();
      }
   }

   private class ExitAction extends AbstractAction {
      public ExitAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         // clean up an problems
         Window win = SwingUtilities.getWindowAncestor(SimpleGui.this);
         win.dispose();
      }
   }

   private static void createAndShowGui() {
      SimpleGui mainPanel = new SimpleGui();

      JFrame frame = new JFrame("SimpleGui");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      // so that the program runs on the Swing event thread
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class SimpleDetails {
   private String firstName;
   private String lastName;

   public SimpleDetails(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   @Override
   public String toString() {
      return lastName + ", " + firstName;
   }

}

class Validate {
   public static boolean test(SimpleDetails simpleDetails) {
      if (simpleDetails.getFirstName().trim().isEmpty()) {
         return false;
      }
      if (simpleDetails.getLastName().trim().isEmpty()) {
         return false;
      }

      // default, has passed all tests
      return true;
   }
}