import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class MyWindow extends JPanel {
   private static final int ROWS = 10;
   private static final int COLS = 50;
   private static final String[] BUTTON_NAMES = { "Monday", "Tuesday",
         "Wednesday", "Thursday", "Friday" };
   private static final int GAP = 3;
   private JTextArea inputTextArea = new JTextArea(ROWS, COLS);
   private JTextArea outputTextArea = new JTextArea(ROWS, COLS);

   public MyWindow() {
      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, GAP, 0));
      for (String btnName : BUTTON_NAMES) {
         buttonPanel.add(new JButton(btnName));
      }
      outputTextArea.setFocusable(false);
      outputTextArea.setEditable(false);

      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
      add(buttonPanel);
      add(putInTitledScrollPane(inputTextArea, "Input Text"));
      add(putInTitledScrollPane(outputTextArea, "Output Text"));
   }

   private JPanel putInTitledScrollPane(JComponent component,
         String title) {
      JPanel wrapperPanel = new JPanel(new BorderLayout());
      wrapperPanel.setBorder(BorderFactory.createTitledBorder(title));
      wrapperPanel.add(new JScrollPane(component));
      return wrapperPanel;
   }

   private static void createAndShowGui() {
      MyWindow mainPanel = new MyWindow();

      JFrame frame = new JFrame("MyWindow");
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