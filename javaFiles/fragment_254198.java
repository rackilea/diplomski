import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestGround extends JPanel {

    private Image img;
    ImageIcon ii ;


    public TestGround(){
        setBackground(Color.BLACK);
        setFocusable(true);

        // load the image in the constructor:
        ImageIcon ii = new ImageIcon("src/resources/picon.png");
        img = ii.getImage();       
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }


    private void doDrawing(Graphics g) {    
         //drawing a grid of lines
         Graphics2D g2d = (Graphics2D) g;
         // draw the image:
         g.drawImage(img, 0, 0, null);

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame frame = new JFrame();
        frame.add(new TestGround());
        frame.setTitle("Show Image");
        frame.setSize(800, 600);       
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

}