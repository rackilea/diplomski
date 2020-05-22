import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

public class Interface {

    private JFrame frame;

    public Interface(){
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Button panel with open file and draw digit buttons
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        DrawPanel displayPanel = new DrawPanel();

        JButton openFileButton = new JButton("Open File");
        openFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedImage image = new FileSelector().createBufferedImage();
                displayPanel.setImage(image);
                frame.pack();
            }
        });

        buttonPanel.add(openFileButton);

        frame.getContentPane().add(displayPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new Interface());
    }
}

class DrawPanel extends JPanel{

    private BufferedImage image;

    public DrawPanel() {
        setPreferredSize(new Dimension (150, 150));
        setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(image != null) {
            g.drawImage(image, 0,0, null);
        }
    }

    void setImage(BufferedImage image) {
        this.image = image;
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }
}

class FileSelector {

    public BufferedImage createBufferedImage(){
        try {
            URL url = new URL("http://www.digitalphotoartistry.com/rose1.jpg");
            return ImageIO.read(url);
        } catch ( IOException ex) { ex.printStackTrace();}
        return null;
    }
}