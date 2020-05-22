package rotateOnImage;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.swing.Action;

public class MainFrame extends JFrame {

/**
 * 
 */
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private MyPanel panel = new MyPanel();
private final Action upAction = new upAction();
private final Action dnAction = new dnAction();

/**
 * Launch the application.
 */
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

/**
 * Create the frame.
 */
public MainFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 345, 227);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JButton btnNewButton = new JButton("UP");
    btnNewButton.setAction(upAction);
    btnNewButton.setBounds(212, 12, 117, 25);
    contentPane.add(btnNewButton);

    JButton button = new JButton("DN");
    button.setAction(dnAction);
    button.setBounds(212, 49, 117, 25);
    contentPane.add(button);

    panel.setBounds(0, 0, 200, 200);

    contentPane.add(panel);
}
private class upAction extends AbstractAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public upAction() {
        putValue(NAME, "UP");

    }
    public void actionPerformed(ActionEvent e) {

        panel.up();
    }
}
private class dnAction extends AbstractAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public dnAction() {
        putValue(NAME, "DN");

    }
    public void actionPerformed(ActionEvent e) {

        panel.down();
    }
}
}

class MyPanel extends JPanel{

private static final long serialVersionUID = 1L;
/**
 * 
 */

private int degrees  = 0;
private AffineTransform tx = null;
private AffineTransformOp op = null;

private BufferedImage image1 = null;
private BufferedImage image2 = null;
private BufferedImage image3 = null;

Image img = null;

public static final String IMAGE_PATH1 = "http://1.bp.blogspot.com/"+"-fq-oPGBSLp4/Ttoj7DoAMWI/AAAAAAAABtc/t7gKJlfRQuo/s400/secondHand.png";
public static final String IMAGE_PATH2 = "http://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Circle_Fulvous_Solid.svg/200px-Circle_Fulvous_Solid.svg.png";
public static final String IMAGE_PATH3 ="http://www.xtremeskater.com/math/images/circle_radius.png";

public MyPanel(){

    try {
        URL url1 = new URL(IMAGE_PATH1);
        URL url2 = new URL(IMAGE_PATH2);            
        URL url3 = new URL(IMAGE_PATH3);
        image1 = ImageIO.read(url1);
        image2 = ImageIO.read(url2);
        image3 = ImageIO.read(url3);
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }

    img = createImage();
    }

public void up(){
    degrees ++;
    if(degrees == 360) degrees = 0;
    repaint();
}

public void down(){
    degrees --;
    if(degrees == -360) degrees = 0;
    repaint();
}

public int getDregrees(){
    return degrees;
}

private Image createImage(){

    double index = 0.0;

    BufferedImage bufferedImage = new BufferedImage(200,200,BufferedImage.TYPE_INT_ARGB);

    Graphics g = bufferedImage.getGraphics();

    for(index = 0.0; index <= 36; index ++){

      tx = AffineTransform.getRotateInstance(Math.toRadians(index*10), 100, 100);
      op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
      g.drawImage(op.filter(image3, null), 0, 0, null);
  }

      return bufferedImage;
}

public void update(Graphics g){
    paint(g);
}

protected void paintComponent(Graphics g){


    super.paintComponent(g);    

    g.drawImage(image2, 0, 0, null);        //Dibujado de la manecilla
    g.drawImage(img, 0, 0, null);       //Dibujado de la escala 


    //Rotación de la manecilla

    tx = AffineTransform.getRotateInstance(Math.toRadians(degrees), this.getHeight()/2, this.getWidth()/2);
    op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
    g.drawImage(op.filter(image1, null), 0, 0, null);
}
}