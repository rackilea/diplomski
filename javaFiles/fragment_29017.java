import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class MainPanel extends Box{

    public MainPanel(){
        super(BoxLayout.Y_AXIS);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // Create image to paint button to
        BufferedImage buttonImage = new BufferedImage(100, 150, BufferedImage.TYPE_INT_ARGB);
        final Graphics g2d = buttonImage.getGraphics();

        // Create button and paint it to your image
        JButton button = new JButton("Click Me");
        button.setSize(button.getPreferredSize());
        button.paint(g2d);

        // Draw image in desired location
        g.drawImage(buttonImage, 100, 100, null);
    }

    public static void main(String[] args){
     final JFrame frame = new JFrame();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.add(new MainPanel());
     frame.pack();
     frame.setSize(400, 300);
     frame.setLocationRelativeTo(null);
     frame.setVisible(true);
    }
}