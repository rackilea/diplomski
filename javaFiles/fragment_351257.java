import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

public class AU19b extends JPanel{

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.RED);

        int radius = 50;

        g.drawOval(getWidth()/2 - radius,getHeight()/2 - radius, 2*radius, 2*radius);
    }
    public static void main(String[] args){
        JFrame f = new JFrame("Sebastians GUI");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 250);
        f.add(new AU19b());
        f.setVisible(true);
    }
}