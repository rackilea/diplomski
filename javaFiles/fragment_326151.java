import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Biohazard {
    public static void main(String[] args) {
        new Biohazard();
    }

    public Biohazard() {
        JFrame frame = new JFrame("Biohazard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyComponent());
        frame.setSize(260, 280);
        frame.setVisible(true);
    }

    public class MyComponent extends JComponent {
        public void paint(Graphics g) {
            int height = 120;
            int width = 120;
            g.setColor(Color.yellow);
            g.fillOval(60, 60, height, width);
            g.setColor(Color.black);
            g.drawOval(60, 60, height, width);

            int swivels = 6;
            int commonx, commony, commonh, commonw;

            for(int i=0;i<swivels;i++){
                commonx = commony = 120-i*10;
                commonh = commonw = i*20;
                g.drawArc(commonx, commony, commonh, commonw, 60 , 60);
                g.drawArc(commonx, commony, commonh, commonw, 180 , 60);
                g.drawArc(commonx, commony, commonh, commonw, 300 , 60);
            }
        }
    }
}