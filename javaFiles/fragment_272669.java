import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class TimerPlay extends JPanel {
   private DefaultListModel directionJListModel = new DefaultListModel();
   private JList directionJList = new JList(directionJListModel);
   JButton startTimerButton = new JButton(
         new StartTimerBtnAction("Start Timer"));

   public TimerPlay() {
      ActionListener directionBtnListener = new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent actEvt) {
            String actionCommand = actEvt.getActionCommand();
            Direction dir = Direction.valueOf(actionCommand);
            if (dir != null) {
               directionJListModel.addElement(dir);
            }
         }
      };
      JPanel directionBtnPanel = new JPanel(new GridLayout(0, 1, 0, 10));
      for (Direction dir : Direction.values()) {
         JButton dirBtn = new JButton(dir.toString());
         dirBtn.addActionListener(directionBtnListener);
         directionBtnPanel.add(dirBtn);
      }

      add(directionBtnPanel);
      add(new JScrollPane(directionJList));
      add(startTimerButton);
   }

   private class StartTimerBtnAction extends AbstractAction {
      protected static final int MAX_COUNT = 20;

      public StartTimerBtnAction(String title) {
         super(title);
      }

      @Override
      public void actionPerformed(ActionEvent arg0) {
         startTimerButton.setEnabled(false);

         int delay = 100;
         new Timer(delay, new ActionListener() {
            private int count = 0;
            private Direction dir = null;

            @Override
            public void actionPerformed(ActionEvent e) {
               if (count == MAX_COUNT) {
                  count = 0; // restart
                  return;
               } else if (count == 0) {
                  if (directionJListModel.size() == 0) {
                     ((Timer)e.getSource()).stop();
                     startTimerButton.setEnabled(true);
                     return;
                  }
                  // extract from "queue"
                  dir = (Direction) directionJListModel.remove(0);
               }
               System.out.println(dir); // do movement here
               count++;

            }
         }).start();
      }
   }

   private static void createAndShowGui() {
      TimerPlay mainPanel = new TimerPlay();

      JFrame frame = new JFrame("TimerPlay");
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

enum Direction {
   UP, DOWN, LEFT, RIGHT;
}