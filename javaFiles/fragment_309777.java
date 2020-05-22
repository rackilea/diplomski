import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class ImagePlay extends JPanel {
   public static final String IMAGE_PATH = "http://upload.wikimedia.org/wikipedia/" +
        "commons/thumb/3/39/European_Common_Frog_Rana_temporaria.jpg/" +
        "800px-European_Common_Frog_Rana_temporaria.jpg";
   private static final Color RECT_COLOR = new Color(180, 180, 255);
   private BufferedImage img = null;
   Point p1 = null;
   Point p2 = null;

   public ImagePlay() {
      URL imgUrl;
      try {
         imgUrl = new URL(IMAGE_PATH);
         img = ImageIO.read(imgUrl );
         ImageIcon icon = new ImageIcon(img);
         JLabel label = new JLabel(icon) {
            @Override
            protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               myLabelPaint(g);
            }
         };

         setLayout(new BorderLayout());
         add(new JScrollPane(label));

         MouseAdapter mAdapter = new MyMouseAdapter();
         label.addMouseListener(mAdapter);
         label.addMouseMotionListener(mAdapter);

      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private void myLabelPaint(Graphics g) {
      if (p1 != null && p2 != null) {
         int x = Math.min(p1.x, p2.x);
         int y = Math.min(p1.y, p2.y);
         int width = Math.abs(p1.x - p2.x);
         int height = Math.abs(p1.y - p2.y);
         g.setXORMode(Color.DARK_GRAY);
         g.setColor(RECT_COLOR);
         g.drawRect(x, y, width, height);
      }
   }

   private class MyMouseAdapter extends MouseAdapter {

      @Override
      public void mousePressed(MouseEvent e) {
         p1 = e.getPoint();
         p2 = null;
         repaint();
      }

      @Override
      public void mouseDragged(MouseEvent e) {
         p2 = e.getPoint();
         repaint();
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         p2 = e.getPoint();
         repaint();

         int x = Math.min(p1.x, p2.x);
         int y = Math.min(p1.y, p2.y);
         int width = Math.abs(p1.x - p2.x);
         int height = Math.abs(p1.y - p2.y);
         BufferedImage smlImg = img.getSubimage(x, y, width, height);
         ImageIcon icon = new ImageIcon(smlImg);
         JLabel label = new JLabel(icon);
         JOptionPane.showMessageDialog(ImagePlay.this, label, "Selected Image", 
               JOptionPane.PLAIN_MESSAGE);         
      }
   }


   private static void createAndShowGui() {
      ImagePlay mainPanel = new ImagePlay();

      JFrame frame = new JFrame("ImagePlay");
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