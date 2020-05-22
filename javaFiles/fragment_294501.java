import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DrawLine {

    JFrame j;
    JPanel p;
    JScrollPane sp;

    public DrawLine() {
        j = new JFrame();
        p = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawLine(20, 20, 250, 250);
            }
        };
        p.setPreferredSize(new Dimension(300, 300));
        sp = new JScrollPane(p);
        j.getContentPane().add(sp);
        j.setSize(300, 300);
        j.setVisible(true);
    }

    public static void main(String[] args) {
            new DrawLine();
        }
}