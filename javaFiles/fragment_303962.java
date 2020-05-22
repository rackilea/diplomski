import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Main extends Component{
    public static void main(String[] args) {
        Ash[] ash = new Ash[36];
        JFrame f = new JFrame("Game sample");

        JPanel panel1 = new JPanel(new GridLayout(6,6,6,6));
        JPanel[] p1 = new JPanel[36];

        for(int i = 0;i < 36;i++){
          p1[i] = new JPanel(new BorderLayout());
          ash[i] = new Ash();
          p1[i].add(ash[i]);
          panel1.add(p1[i]);
        }
        f.add(panel1,BorderLayout.CENTER);
        f.setSize(500,500);
        f.setVisible(true);
        long start, trigger = 0, delay = 1000 / 8;
        while(true) {
            start = System.currentTimeMillis();
            if(start > trigger) {
                trigger = start + delay;
                for (int ii=0; ii<ash.length; ii++) {
                    ash[ii].repaint();
                }
            }
        }
    }
}

class Ash extends JPanel{

    BufferedImage sprite[] = {
        new BufferedImage(25,100,BufferedImage.TYPE_INT_RGB),
        new BufferedImage(55,100,BufferedImage.TYPE_INT_RGB),
        new BufferedImage(75,100,BufferedImage.TYPE_INT_RGB),
        new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB)
    };
    int step = 0, start = 0;

    int count = 0;


    public Ash() {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(sprite[count++%4],0,10,null);
        if(step == 96) {
            step = 0;
        } else {
            step += 32;
        }
    }
}