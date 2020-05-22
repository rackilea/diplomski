import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;

public class CurveDraw extends JFrame {
        public static void main(String[] args) {
                CurveDraw frame = new CurveDraw();
                frame.setVisible(true);
        }
        public CurveDraw() {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(400,400);
        }
        public void paint(Graphics g) {
                QuadCurve2D.Double curve = new QuadCurve2D.Double(50,100,100,170,150,100);
                ((Graphics2D)g).draw(curve);
        }
}