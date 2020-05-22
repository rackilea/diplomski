import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyTimerGui {
   private static final String TITLE = "Flashing Label";
   private static final int TIMER_DELAY = 200;
   private static final int GAP = 3;
   private static final float LABEL_POINTS = 32F;
   private JPanel mainPanel = new JPanel();
   private JLabel flashyLabel = new JLabel(TITLE, SwingConstants.CENTER);
   private Timer timer = new Timer(TIMER_DELAY, new TimerListener());

   public MyTimerGui() {
      Font font = flashyLabel.getFont();
      font = font.deriveFont(LABEL_POINTS);
      flashyLabel.setFont(font);
      flashyLabel.setOpaque(true);

      JPanel buttonPanel = new JPanel(new GridLayout(1, 0, GAP, 0));
      buttonPanel.add(new JButton(new StartAction(this, "Start", KeyEvent.VK_S)));
      buttonPanel.add(new JButton(new StopAction(this, "Stop", KeyEvent.VK_T)));
      buttonPanel.add(new JButton(new ExitAction(this, "Exit", KeyEvent.VK_X)));

      mainPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
      mainPanel.setLayout(new BorderLayout());
      mainPanel.add(flashyLabel, BorderLayout.CENTER);
      mainPanel.add(buttonPanel, BorderLayout.PAGE_END);
   }

   public JComponent getMainComponent() {
      return mainPanel;
   }

   public void start() {
      timer.start();
   }

   public void stop() {
      timer.stop();
      flashyLabel.setForeground(null);
      flashyLabel.setBackground(null);
   }

   public void exit() {
      timer.stop();
      Window win = SwingUtilities.getWindowAncestor(mainPanel);
      win.dispose();
   }

   private class TimerListener implements ActionListener {
      private final Color foreground1 = Color.green;
      private final Color background1 = Color.red;

      @Override
      public void actionPerformed(ActionEvent aEvt) {
         Color fg = flashyLabel.getForeground();
         if (foreground1.equals(fg)) {
            flashyLabel.setForeground(null);
            flashyLabel.setBackground(null);
         } else {
            flashyLabel.setForeground(foreground1);
            flashyLabel.setBackground(background1);
         }
      }
   }

   private class StartAction extends AbstractAction {
      private MyTimerGui myTimerGui;

      public StartAction(MyTimerGui myTimerGui, String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
         this.myTimerGui = myTimerGui;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         myTimerGui.start();
      }
   }

   private class StopAction extends AbstractAction {
      private MyTimerGui myTimerGui;

      public StopAction(MyTimerGui myTimerGui, String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
         this.myTimerGui = myTimerGui;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         myTimerGui.stop();
      }
   }

   private class ExitAction extends AbstractAction {
      private MyTimerGui myTimerGui;

      public ExitAction(MyTimerGui myTimerGui, String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
         this.myTimerGui = myTimerGui;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         myTimerGui.exit();
      }
   }

   private static void createAndShowGui() {
      MyTimerGui myTimerGui = new MyTimerGui();

      JFrame frame = new JFrame("MyTimer");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(myTimerGui.getMainComponent());
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