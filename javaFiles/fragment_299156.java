import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImageMoveTest implements ActionListener {
 JPanel panel;
 Image rimg;
 Thread t;
 int x;
 int y;
 int v;
 int z;
 int n;

 public static void main(String[] args) throws InterruptedException,  IOException {
  SwingUtilities.invokeLater(new Runnable() {
   public void run() {
   try {
       new ImageMoveTest().startApp();
   } catch (InterruptedException ex) {
       Logger.getLogger(ImageMoveTest.class.getName()).log(Level.SEVERE,  null, ex);
   } catch (IOException ex) {
       Logger.getLogger(ImageMoveTest.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  });
 } 

 public void startApp() throws InterruptedException, IOException {
  panel = new DrawPanel();
  InputStream inStream =  this.getClass().getClassLoader().getResourceAsStream("i6.jpeg");
  BufferedImage img = ImageIO.read(inStream);
  rimg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
  MoveMouse mm = new MoveMouse();
  panel.addMouseMotionListener((MouseMotionListener) mm);

  JFrame f = new JFrame();
  f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
  f.getContentPane().add(panel).setBackground(Color.white);
  f.setSize(750, 750);
  f.setResizable(false);
  f.setVisible(true);
  f.setLocationRelativeTo(null);
  MathC mc = new MathC();
  t = new Thread(mc);
  t.start();
 }

 class MoveMouse extends JPanel implements MouseMotionListener {
  @Override
  public void mouseDragged(MouseEvent e) {
   v=e.getX();  
   z=e.getY();
   this.repaint();
  }

  @Override
  public void mouseMoved(MouseEvent e) {

  }
 } 

 class MathC implements Runnable {
  @Override
  public void run() {
   while(true) {
    // x,y here
    x = (int) (Math.random() * panel.getWidth());
    y = (int) (Math.random() * panel.getHeight());
    panel.repaint();
     try {
       t.sleep(700);
     } catch (InterruptedException ex) {
       Logger.getLogger(ImageMoveTest.class.getName()).log(Level.SEVERE,  null, ex);
      }
     } 
    } 
   }
   @Override
   public void actionPerformed(ActionEvent e) {
    throw new UnsupportedOperationException("Not supported yet."); //To  change body of generated methods, choose Tools | Templates.
   }

   class DrawPanel extends JPanel {
    public void update(Graphics g) {
     super.paintChildren(g);
    }   

    public void paintChildren( Graphics g) {
     super.paintChildren(g);
     drawIt(g);
     // repaint the backround to see the single circle moving
     // draw the Ball
     g.setColor(Color.red);
     g.fillOval(x, y, 35, 35);
     g.drawOval(x, y, 35, 35);
     this.repaint();
    }
    public void drawIt(Graphics g) {
     super.paintChildren(g);
     // draw Rectangle
     g.drawRect(0,0,this.getWidth(),this.getHeight());     
     // draw the Image
     g.drawImage(rimg, v, z, this);
     this.repaint();
    }
   }
  }