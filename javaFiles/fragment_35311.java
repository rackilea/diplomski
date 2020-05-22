import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class OpenImageZooming {

 private static final int NB_STEPS = 30;

 private static final long OPENING_TOTAL_DURATION = 3000;

 public static void main(String[] args) {
  OpenImageZooming me = new OpenImageZooming();
  me.openImage(args[0]);
 }

 private JFrame frame;
 private JDialog dialog;
 private JPanelZooming panelZooming;

 private void openImage(final String imagePath) {
  SwingUtilities.invokeLater(new Runnable() {
   public void run() {
    frame = new JFrame();
    frame.setTitle("Open image with zoom");
    JPanel p = new JPanel(new BorderLayout());
    p.add(new JLabel("click on button to display image"), BorderLayout.CENTER);
    JButton button = new JButton("Display!");
    frame.setContentPane(p);
    button.addActionListener(new ActionListener() {

     public void actionPerformed(ActionEvent e) {
      Thread t = new Thread() {

       @Override
       public void run() {
        displayImaggeWithProgressiveZoom(imagePath);
       }

      };
      t.start();

     }

    });
    p.add(button, BorderLayout.SOUTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 100);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
   }
  });
 }

 protected void displayImaggeWithProgressiveZoom(String imagePath) {
  try {
   final BufferedImage image = ImageIO.read(new File(imagePath));

   for (int i = 0; i < NB_STEPS; i++) {
    displayDialog(i, NB_STEPS, image);

    Thread.sleep(OPENING_TOTAL_DURATION / NB_STEPS);
   }

  } catch (Exception e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }

 }

 private void displayDialog(final int i, final int nbSteps, final BufferedImage image) {

  try {
   SwingUtilities.invokeAndWait(new Runnable() {
    public void run() {
     if (dialog == null) {
      dialog = new JDialog(frame);
      dialog.setUndecorated(true);
      dialog.setModal(false);
      panelZooming = new JPanelZooming(image);
      dialog.setContentPane(panelZooming);
      dialog.setSize(0, 0);
      dialog.setLocationRelativeTo(frame);
      dialog.setVisible(true);

     }
     int w = (i + 1) * image.getWidth() / nbSteps;
     int h = (i + 1) * image.getHeight() / nbSteps;

     panelZooming.setScale((double) (i + 1) / nbSteps);
     dialog.setSize(w, h);
     dialog.setLocationRelativeTo(null);
    }
   });
  } catch (InterruptedException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (InvocationTargetException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }

 }

 @SuppressWarnings("serial")
 public static class JPanelZooming extends JPanel {

  private BufferedImage image;

  private double scale = 1.0d;

  public JPanelZooming(BufferedImage image) {
   this.image = image;
  }

  @Override
  protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   Graphics2D g2 = (Graphics2D) g;
   AffineTransform at = g2.getTransform();
   AffineTransform oldTransform = (AffineTransform) at.clone();
   at.scale(scale, scale);
   g2.setTransform(at);
   g2.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
   g2.setTransform(oldTransform);

  }

  public void setScale(double scale) {
   this.scale = scale;
  }

 }
}