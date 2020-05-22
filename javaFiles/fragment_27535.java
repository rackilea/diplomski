import java.awt.*;
import java.awt.image.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class SillyNAmeForAMainClassGivenIHave100CalledMain {

public static void main(String[] args) throws IOException {
    final Image image = new BufferedImage(400,200,BufferedImage.TYPE_INT_RGB);
    final JFrame frame = new JFrame();
    frame.add(new ImagePanel(image));
    //frame.setSize(800, 600);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}
}

@SuppressWarnings("serial")
class ImagePanel extends JPanel {
private Image image;
private boolean tile;
// add 5px spacing between buttons
private JPanel menu = new JPanel(new GridLayout(4,4,5,5));

ImagePanel(Image image) {
    super(new BorderLayout());  // default is FlowLayout!
    this.image = image;
    this.tile = false;
    final JButton play = new JButton("PLAY");
    final JButton help = new JButton("HELP");

    menu.add(play);
    menu.add(help);

    JPanel buttonConstrain = new JPanel(new FlowLayout());
    // pad the top of it..
    buttonConstrain.setBorder(new EmptyBorder(20,5,5,5));
    buttonConstrain.setOpaque(false);
    buttonConstrain.add(menu);
    // it won't help to use a BorderLayout contraint when the default is FlowLayout!
    // LINE_START = 'left' for left-to-right locales, right for the other
    add(buttonConstrain,BorderLayout.LINE_START);
    menu.setOpaque(false);

    setVisible(true);
}

@Override
public Dimension getPreferredSize() {
    Dimension d = null;
    if (image != null) {
        d = new Dimension(image.getWidth(this), image.getHeight(this));
    } else {
        d = new Dimension(600,400);
    }
    return d;
}

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (tile) {
        int iw = image.getWidth(this);
        int ih = image.getHeight(this);
        if (iw > 0 && ih > 0) {
            for (int x = 0; x < getWidth(); x += iw) {
                for (int y = 0; y < getHeight(); y += ih) {
                    g.drawImage(image, x, y, iw, ih, this);
                }
            }
        }
    } else {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
  }
}