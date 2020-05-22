import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventDrivenGui extends JPanel {
   private static final Color GO_COLOR = Color.green;
   private static final Color STOP_COLOR = Color.red;
   private static final int SIDE = 300;
   private static final int TIMER_DELAY = 4 * 1000; // change light every 4 seconds
   private boolean go = false;
   private JButton button = new JButton("Button");


   public EventDrivenGui() {
      add(button);
      button.addActionListener(new ButtonListener());
      new Timer(TIMER_DELAY, new TimerListener()).start();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

      Color color = go ? GO_COLOR : STOP_COLOR;
      g2.setColor(color);
      g2.fillOval(0, SIDE / 3, SIDE, SIDE);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(SIDE, (4 * SIDE) / 3);
   }

   private class ButtonListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent arg0) {
         if (go) {
            JOptionPane.showMessageDialog(EventDrivenGui.this, "Button is Active");
         }
      }
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // toggle go. if true, now false, and visa versa
         go = !go;
         repaint(); // redraw oval
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            EventDrivenGui mainPanel = new EventDrivenGui();

            JFrame frame = new JFrame("EventDrivenGui");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(mainPanel);
            frame.pack();
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
         }
      });
   }

}