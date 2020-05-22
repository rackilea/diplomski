import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

import javax.swing.*;

@SuppressWarnings("serial")
public class RotateFoo extends JPanel {

   private static final int PREF_WIDTH = 800;
   private static final int PREF_HEIGHT = 600;
   private static final Color STAR_COLOR = Color.red;
   private static final int ROTATE_TIMER_DELAY = 20;
   private static final int POINTS = 5;
   private static final int RADIUS = 50;
   private static final String TITLE = "Press \"r\" to rotate";
   private static final float TITLE_POINTS = 52f;

   private Path2D star = new Path2D.Double(); 
   private Timer rotateTimer = new Timer(ROTATE_TIMER_DELAY, new RotateTimerListener());

   public RotateFoo() {
      double x = 0.0;
      double y = 0.0;
      double theta = 0.0;
      for (int i = 0; i <= POINTS; i++) {
         x = RADIUS + RADIUS * Math.cos(theta);
         y = RADIUS + RADIUS * Math.sin(theta);
         if (i == 0) {
            star.moveTo(x, y);            
         } else {
            star.lineTo(x, y);
         }
         theta += 4 * Math.PI / POINTS;
      }

      double tx = (getPreferredSize().getWidth() - star.getBounds().getWidth()) / 2;
      double ty = (getPreferredSize().getHeight() - star.getBounds().getHeight()) / 2;
      AffineTransform at = AffineTransform.getTranslateInstance(tx, ty);
      star.transform(at );

      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();
      String rotateOn = "rotate on";
      String rotateOff = "rotate off";
      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0, false), rotateOn);
      actionMap.put(rotateOn, new AbstractAction() {

         public void actionPerformed(ActionEvent arg0) {
            if (rotateTimer != null && !rotateTimer.isRunning()) {
               rotateTimer.start();
            }
         }
      });
      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0, true), rotateOff);
      actionMap.put(rotateOff, new AbstractAction() {

         public void actionPerformed(ActionEvent arg0) {
            if (rotateTimer != null && rotateTimer.isRunning()) {
               rotateTimer.stop();
            }
         }
      });
      //rotateTimer.start();

      JLabel titleLabel = new JLabel(TITLE, SwingConstants.CENTER);
      titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, TITLE_POINTS));
      add(titleLabel);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_WIDTH, PREF_HEIGHT);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(STAR_COLOR);

      if (star != null) {
         g2.draw(star);
      }
   }

   private class RotateTimerListener implements ActionListener {
      private static final double BASE_THETA = Math.PI / 90;

      @Override
      public void actionPerformed(ActionEvent e) {
         double anchorx = getPreferredSize().getWidth() / 2;
         double anchory = getPreferredSize().getHeight() / 2;
         AffineTransform at = AffineTransform.getRotateInstance(BASE_THETA, anchorx, anchory);
         star.transform(at);
         repaint();
      }
   }

   private static void createAndShowGui() {
      RotateFoo mainPanel = new RotateFoo();

      JFrame frame = new JFrame("RotateFoo");
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