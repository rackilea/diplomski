import javax.swing.*;

// this guy extends *nothing*
public class TunaExample {
   private static final int COLS = 10;
   private JPanel mainPanel = new JPanel(); // this is what I'll add to contentPane
   private JTextField field1 = new JTextField(COLS);
   private JTextField field2 = new JTextField(COLS);
   private JPasswordField passwordField = new JPasswordField(COLS);
   private JComponent[] allComponents = { new JLabel("Field 1:"), field1,
         new JLabel("Field 2:"), field2, new JLabel("Password:"), passwordField };

   public TunaExample() {
      field2.setEditable(false);
      field2.setFocusable(false);
      field1.setText("Field 1");
      field2.setText("Uneditable");

      for (JComponent comp : allComponents) {
         mainPanel.add(comp);
      }
   }

   public JComponent getMainComponent() {
      return mainPanel;
   }

   private static void createAndShowGui() {
      TunaExample tunaExample = new TunaExample();

      // creating my JFrame only when I need it and where I need it
      JFrame frame = new JFrame("Tuna Example");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(tunaExample.getMainComponent());
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