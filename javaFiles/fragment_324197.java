import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class Main2 {

   private static void createAndShowGUI() {
      JPanel mainPanel = new ControlPanel();

      JFrame frame = new JFrame("Main2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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

class ControlPanel extends JPanel {
   private static final int LOG_ROWS = 15;
   private static final int LOG_COLS = 40;
   private JButton resetButton = new JButton("Reset");
   private JPanel logPanel = new JPanel();
   private JLabel actionLogsLabel = new JLabel("Action Log");
   private JLabel pointsLogsLabel = new JLabel("Points Log");
   private JTextArea actionLog = new JTextArea();
   private JTextArea pointsLog = new JTextArea();
   private JScrollPane actionScroll;
   private JScrollPane pointsScroll;

   public ControlPanel() {
      init();
      this.add(resetButton);
      this.add(logPanel);
   }

   private void init() {
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      this.setAlignmentX(LEFT_ALIGNMENT);
      this.logPanel.setLayout(new BoxLayout(logPanel, BoxLayout.Y_AXIS));
      this.logPanel.setAlignmentX(LEFT_ALIGNMENT);
      // !! actionLog.setPreferredSize(new Dimension(500, 300));
      // !! actionLog.setMaximumSize(actionLog.getPreferredSize());
      actionLog.setRows(LOG_ROWS); // !!
      actionLog.setColumns(LOG_COLS); // !!

      actionLog.setEditable(false);
      actionLog.setWrapStyleWord(true);
      DefaultCaret caret = (DefaultCaret) actionLog.getCaret();
      caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
      // !! pointsLog.setPreferredSize(new Dimension(500, 300));
      // !! pointsLog.setMaximumSize(pointsLog.getPreferredSize());
      pointsLog.setRows(LOG_ROWS); // !!
      pointsLog.setColumns(LOG_COLS); // !!

      pointsLog.setEditable(false);
      pointsLog.setWrapStyleWord(true);
      pointsScroll = new JScrollPane(pointsLog,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      actionScroll = new JScrollPane(actionLog,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      logPanel.add(actionLogsLabel);
      logPanel.add(actionScroll);
      for (int i = 0; i < 500; i++) {
         actionLog.setText(actionLog.getText() + "Line: " + i + "\n");
      }
      logPanel.add(pointsLogsLabel);
      logPanel.add(pointsScroll);
   }
}