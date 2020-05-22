import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImagePanel extends JPanel {

    private Image image = null;

    ImagePanel(LayoutManager layout) {
        super(layout);
    }

    public void setImage(ImageIcon icon) {
        image = icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            System.out.println("imagepanel painting");
            g.drawImage(image,0,0,getWidth(),getHeight(),null); // see javadoc for more info on the parameters
        }
    }

    public static void main(String[] args) throws Exception {
        JFrame f = new JFrame("Image Panel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        URL url = new URL("http://pscode.org/media/citymorn2.jpg");
        Image image = ImageIO.read(url);

        ImagePanel ip = new ImagePanel(new GridLayout(4,4,20,20) );
        ip.setBorder( new EmptyBorder(50,50,50,50) );
        for (int ii=0; ii<16; ii++) {
            ip.add( new JButton("" + ii) );
        }

        ip.setPreferredSize(new Dimension(640,480));
        f.setContentPane(ip);
        f.pack();
        f.setVisible(true);

        ip.setImage( new ImageIcon(image) );
    }
}