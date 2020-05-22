import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumMap;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class AnimateExample extends JPanel {
   public static final String DUKE_IMG_PATH = // https://duke.kenai.com/iconSized/duke.gif
         "https://duke.kenai.com/iconSized/duke4.gif";
   private static final int PREF_W = 800;
   private static final int PREF_H = 800;
   private static final int TIMER_DELAY = 20;
   private static final String KEY_DOWN = "key down";
   private static final String KEY_RELEASE = "key release";
   public static final int TRANSLATE_SCALE = 3;
   private static final String BACKGROUND_STRING = "Use Arrow Keys to Move Image";
   private static final Font BG_STRING_FONT = new Font(Font.SANS_SERIF,
         Font.BOLD, 32);
   private EnumMap<Direction, Boolean> dirMap = 
         new EnumMap<AnimateExample.Direction, Boolean>(Direction.class);
   private BufferedImage image = null;
   private int imgX = 0;
   private int imgY = 0;
   private int bgStringX; 
   private int bgStringY; 

   public AnimateExample() {
      for (Direction dir : Direction.values()) {
         dirMap.put(dir, Boolean.FALSE);
      }
      try {
         URL imgUrl = new URL(DUKE_IMG_PATH);
         image = ImageIO.read(imgUrl);
         Icon icon = new ImageIcon(image);
         JOptionPane.showMessageDialog(null, icon);
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }

      new Timer(TIMER_DELAY, new TimerListener()).start();

      // here we set up our key bindings
      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();
      for (final Direction dir : Direction.values()) {

         // for the key down key stroke
         KeyStroke keyStroke = KeyStroke.getKeyStroke(dir.getKeyCode(), 0,
               false);
         inputMap.put(keyStroke, dir.name() + KEY_DOWN);
         actionMap.put(dir.name() + KEY_DOWN, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
               dirMap.put(dir, true);
            }
         });

         // for the key release key stroke
         keyStroke = KeyStroke.getKeyStroke(dir.getKeyCode(), 0, true);
         inputMap.put(keyStroke, dir.name() + KEY_RELEASE);
         actionMap.put(dir.name() + KEY_RELEASE, new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
               dirMap.put(dir, false);
            }
         });
      }

      FontMetrics fontMetrics = getFontMetrics(BG_STRING_FONT);
      int w = fontMetrics.stringWidth(BACKGROUND_STRING);
      int h = fontMetrics.getHeight();

      bgStringX = (PREF_W - w) / 2;
      bgStringY = (PREF_H - h) / 2;
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g.setFont(BG_STRING_FONT);
      g.setColor(Color.LIGHT_GRAY);
      g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
      g.drawString(BACKGROUND_STRING, bgStringX, bgStringY);

      if (image != null) {
         g.drawImage(image, imgX, imgY, this);
      }
   }

   private class TimerListener implements ActionListener {
      public void actionPerformed(java.awt.event.ActionEvent e) {
         for (Direction dir : Direction.values()) {
            if (dirMap.get(dir)) {
               imgX += dir.getX() * TRANSLATE_SCALE;
               imgY += dir.getY() * TRANSLATE_SCALE;
            }
         }
         repaint();
      };
   }

   enum Direction {
      Up(KeyEvent.VK_UP, 0, -1), Down(KeyEvent.VK_DOWN, 0, 1), Left(
            KeyEvent.VK_LEFT, -1, 0), Right(KeyEvent.VK_RIGHT, 1, 0);

      private int keyCode;
      private int x;
      private int y;

      private Direction(int keyCode, int x, int y) {
         this.keyCode = keyCode;
         this.x = x;
         this.y = y;
      }

      public int getKeyCode() {
         return keyCode;
      }

      public int getX() {
         return x;
      }

      public int getY() {
         return y;
      }

   }

   private static void createAndShowGui() {
      AnimateExample mainPanel = new AnimateExample();

      JFrame frame = new JFrame("Animate Example");
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