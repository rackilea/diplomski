import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class grafico extends JPanel implements ActionListener {
    Timer tm = new Timer(5, this);
    int x1 = 0;
    int x2 = 0;
    int velX1 = 1;
    int velX2 = 1;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x1, 160, 10, 10);
        g.setColor(Color.BLUE);
        g.fillRect(x2, x2, 10, 10);     
    }

    public void actionPerformed(ActionEvent e) {
        if (x1 < 0 || x1 > 500)
            velX1 = -velX1;
        x1 = x1 + velX1;

        if (x2 < 0 || x2 > 350)
            velX2 = -velX2;
        x2 = x2 + velX2;

        if( checkCollition() ) { // only two show the Idea.
            velX2 = -velX2;      // this code is not simulating a 
            x2 = x2 + velX2;     //    collision. You should change it
                                 //    in the future.
        }
        repaint();
    }

    private boolean checkCollition() {
        return Math.abs(x1-x2) < 10 && Math.abs(160-x2) < 10;
    }

    public static void main(String[] args) {
        grafico t = new grafico();
        JFrame jf = new JFrame();
        jf.setTitle("Tutorial");
        jf.setSize(600, 400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(t);
        t.tm.start();
    }
}