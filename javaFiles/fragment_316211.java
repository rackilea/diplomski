import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

@SuppressWarnings("serial")
public class FillingBar2 extends JApplet {
   @Override
   public void init() {
      try {
         SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
               FillingBarPanel fillingBarPanel = new FillingBarPanel();
               add(fillingBarPanel);
               add(new JButton(new StartAction(fillingBarPanel)), BorderLayout.PAGE_END);
               setSize(getPreferredSize());
            }
         });
      } catch (InvocationTargetException | InterruptedException e) {
         System.err.println("Big Problems");
         e.printStackTrace();
      }
   }
}

@SuppressWarnings("serial")
class StartAction extends AbstractAction {
   private FillingBarPanel fillingBarPanel;

   public StartAction(FillingBarPanel fillingBarPanel) {
      super("Start");
      putValue(MNEMONIC_KEY, KeyEvent.VK_S);
      this.fillingBarPanel = fillingBarPanel;
   }

   @Override
   public void actionPerformed(ActionEvent evt) {
      fillingBarPanel.start();
   }
}

@SuppressWarnings("serial")
class FillingBarPanel extends JPanel {
   private static final int BAR_WIDTH = 20;
   private static final int TIMER_DELAY = 100;
   private static final int PREF_W = 400;
   private static final int PREF_H = 250;
   private int filling = 0;
   private Timer timer;

   public FillingBarPanel() {
      timer = new Timer(TIMER_DELAY, new TimerListener());
   }

   public void start() {
      if (timer != null && !timer.isRunning()) {
         timer.start();
      }
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      int shifting = 0;
      for (int i = 0; i < filling / getHeight(); i++) {
         shifting = i * BAR_WIDTH;
         g.setColor(Color.GREEN);
         g.fillRect(shifting, 0, BAR_WIDTH, getHeight());

         g.setColor(Color.BLACK);
         g.drawRect(shifting, 0, BAR_WIDTH, getHeight());
      }
      shifting = BAR_WIDTH * (filling / getHeight());
      g.setColor(Color.GREEN);
      g.fillRect(shifting, getHeight() - (filling % getHeight()), BAR_WIDTH, getHeight());

      g.setColor(Color.BLACK);
      g.drawRect(shifting, getHeight() - (filling % getHeight()), BAR_WIDTH, getHeight());
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evt) {
         filling += 10;
         repaint();
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

}