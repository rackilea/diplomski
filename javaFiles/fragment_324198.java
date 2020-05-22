import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class Main2B {

   private static void createAndShowGUI() {
      ControlPanel2B controlPanel = new ControlPanel2B();
      controlPanel.setBorder(BorderFactory.createEtchedBorder());

      JPanel mainPanel = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      mainPanel.add(controlPanel, gbc);

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

@SuppressWarnings("serial")
class ControlPanel2B extends JPanel {
   private static final int LOG_ROWS = 15;
   private static final int LIST_WIDTH = 500;
   private JButton resetButton = new JButton("Reset");
   private JPanel logPanel = new JPanel();
   private JLabel actionLogsLabel = new JLabel("Action Log");
   private JLabel pointsLogsLabel = new JLabel("Points Log");

   private DefaultListModel<String> actionLogListModel = new DefaultListModel<>();
   private JList<String> actionLogList = new JList<String>(actionLogListModel);
   private DefaultListModel<String> pointsLogListModel = new DefaultListModel<>();
   private JList<String> pointsLogList = new JList<String>(pointsLogListModel);
   private JScrollPane actionScroll;
   private JScrollPane pointsScroll;

   public ControlPanel2B() {
      init();
      this.add(resetButton);
      this.add(logPanel);
   }

   private void init() {
      actionLogList.setVisibleRowCount(LOG_ROWS);
      pointsLogList.setVisibleRowCount(LOG_ROWS);
      actionLogList.setFixedCellWidth(LIST_WIDTH);

      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      this.setAlignmentX(LEFT_ALIGNMENT);
      this.logPanel.setLayout(new BoxLayout(logPanel, BoxLayout.Y_AXIS));
      this.logPanel.setAlignmentX(LEFT_ALIGNMENT);
      pointsScroll = new JScrollPane(pointsLogList,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      actionScroll = new JScrollPane(actionLogList,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      logPanel.add(actionLogsLabel);
      logPanel.add(actionScroll);
      for (int i = 0; i < 500; i++) {
         actionLogListModel.addElement("Line: " + i);
      }
      logPanel.add(pointsLogsLabel);
      logPanel.add(pointsScroll);
   }
}