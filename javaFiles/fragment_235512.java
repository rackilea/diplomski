import java.awt.BorderLayout;
import javax.swing.*;

public class MainFrame2 extends JPanel {

   private JTabbedPane tabbedPane = new JTabbedPane();
   private JTextArea textArea = new JTextArea(20, 40);

   public MainFrame2() {
      tabbedPane.add("Bahahahaha", new JPanel());
      tabbedPane.add("TextArea Info", createTextAreaPane());

      setLayout(new BorderLayout());
      add(tabbedPane, BorderLayout.CENTER);
   }

   private JComponent createTextAreaPane() {
      JPanel btnPanel = new JPanel();
      btnPanel.add(new JButton("Save"));

      JPanel textAreaPane = new JPanel(new BorderLayout());
      textAreaPane.add(new JScrollPane(textArea), BorderLayout.CENTER);
      textAreaPane.add(btnPanel, BorderLayout.SOUTH);
      return textAreaPane;
   }

   private static void createAndShowGui() {
      MainFrame2 mainPanel = new MainFrame2();

      JFrame frame = new JFrame("Main Frame");
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