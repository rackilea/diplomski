import java.awt.BorderLayout;

import javax.swing.*;

public class ChatPanel extends JPanel {
   private static final long serialVersionUID = 1L;
   private static final int ROWS = 15;
   private static final int COLS = 30;
   private JTextArea textArea = new JTextArea(ROWS, COLS);
   private JTextField textField = new JTextField(COLS);

   public ChatPanel() {
      JScrollPane scrollPane = new JScrollPane(textArea);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

      setLayout(new BorderLayout());
      add(scrollPane, BorderLayout.CENTER);
      add(textField, BorderLayout.PAGE_END);
   }

   private static void createAndShowGUI() {
      ChatPanel paintEg = new ChatPanel();

      JFrame frame = new JFrame("ChatPanel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(paintEg);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}