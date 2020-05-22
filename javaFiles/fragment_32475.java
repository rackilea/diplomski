import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class FromGraphicsToBufferedImage extends JPanel{
   private static final int BI_WIDTH = 600;
   private static final int BI_HEIGHT = BI_WIDTH;
   private static BufferedImage bImage = new BufferedImage(BI_WIDTH, BI_HEIGHT, BufferedImage.TYPE_INT_ARGB); //Enregistrement de l'image en RGBA
   private List<Point> pointList = new ArrayList<Point>();
   private JLabel imageLabel;
   private boolean isInit = false;
   private static ArrayList<BufferedImage> historic = new ArrayList<BufferedImage>();
   private int historicIndex = 0;

   //Constructeur
   public FromGraphicsToBufferedImage() {
      imageLabel = new JLabel(new ImageIcon(bImage)) {
         @Override
         protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paintInLabel(g);
         }
      };


      MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
      imageLabel.addMouseListener(myMouseAdapter);
      imageLabel.addMouseMotionListener(myMouseAdapter);
      imageLabel.setBorder(BorderFactory.createEtchedBorder());

      JButton saveImageBtn = new JButton("Save Image");
      saveImageBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            saveImageActionPerformed();
         }
      });

      JButton clearImageBtn = new JButton("Clear Image");
      clearImageBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Graphics2D g2 = bImage.createGraphics();
            g2.setBackground(new Color(255,255,255,0));
            g2.clearRect(0, 0, BI_WIDTH, BI_HEIGHT);
            g2.dispose();
            imageLabel.repaint();
         }
      });

      JButton undo = new JButton("Undo");
      undo.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             System.out.println("UNDO");
             historicIndex -= 1;
             bImage = historic.get(historicIndex);
             Graphics2D g2 = bImage.createGraphics();
             g2.drawImage(bImage, 0, 0, bImage.getWidth(), bImage.getHeight(), imageLabel);
             g2.dispose();
             imageLabel.setIcon(new ImageIcon(bImage));
             imageLabel.repaint();
          }
       });

      JPanel btnPanel = new JPanel();
      btnPanel.add(saveImageBtn);
      btnPanel.add(clearImageBtn);
      btnPanel.add(undo);

      setLayout(new BorderLayout());
      add(imageLabel, BorderLayout.CENTER);
      add(btnPanel, BorderLayout.SOUTH);
   } //Fin du Constructeur

   private void saveImageActionPerformed() {
      JFileChooser filechooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
      filechooser.setFileFilter(filter);
      int result = filechooser.showSaveDialog(this);
      if (result == JFileChooser.APPROVE_OPTION) {
         File saveFile = filechooser.getSelectedFile();
         try {
            ImageIO.write(bImage, "png", saveFile);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   private void paintInLabel(Graphics g) {
      Graphics2D g2d = (Graphics2D) g;
      g2d = bImage.createGraphics();
      if(isInit == false) {
          g2d.setColor(Color.RED);
          g2d.fillRect(0, 0, BI_WIDTH, BI_HEIGHT);
          g2d.dispose();
          isInit = true;
      }
      else {
          g2d.setColor(Color.BLUE);
          if(pointList.size() == 0) {
              return;
          }
          //System.out.println(bImage.getRGB(50, 50));
          int x1 = pointList.get(0).x;
          int y1 = pointList.get(0).y;
          int x2 = pointList.get(0).x+32;
          int y2 = pointList.get(0).y+32;
          g2d.setComposite(AlphaComposite.Src);
          g2d.setColor(new Color(255,255,255,0));
          g2d.fillRect(x1,y1,32,32);
          g2d.dispose();
          pointList.clear();
      }
      historic.add(deepCopy(bImage));
      imageLabel.repaint();
   }

   private class MyMouseAdapter extends MouseAdapter {

      @Override
      public void mousePressed(MouseEvent e) {
         pointList.add(e.getPoint());
         imageLabel.repaint();
      }

      @Override
      public void mouseReleased(MouseEvent e) {
          //historic.add(deepCopy(bImage));
          System.out.println("Historic Size: " + historic.size());
          int tailleHistorique = historic.size();
          historicIndex = tailleHistorique-1;
          if(historic.size() >= 2) {
              System.out.println("The 2 images are the same: " + compareImages(historic.get(historicIndex-1), historic.get(historicIndex)));
          }
      }
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("DrawAndSaveImage");
      frame.getContentPane().add(new FromGraphicsToBufferedImage());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static BufferedImage getBufferedImage() {
       return bImage;
   }

   public static boolean compareImages(BufferedImage imgA, BufferedImage imgB) {
          if (imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight()) {
            int largeurImage = imgA.getWidth();
            int hauteurImage = imgA.getHeight();

            for (int y = 0; y < hauteurImage; y++) {
              for (int x = 0; x < largeurImage; x++) {
                if (imgA.getRGB(x, y) != imgB.getRGB(x, y)){
                  return false;
                }
              }
            }
          }
          else {
            return false;
          }
          return true;
    }

   static BufferedImage deepCopy(BufferedImage bi) {
       ColorModel cm = bi.getColorModel();
       boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
       WritableRaster raster = bi.copyData(null);
       return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
      }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}