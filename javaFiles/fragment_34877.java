import java.awt.*;

public class FrameTest {
    public static void main(String[] args) throws InterruptedException {

        JFrame f = new JFrame("Demo");
        f.getContentPane().setLayout(new BorderLayout());    
        f.add(new JComponent() {
            public void paintComponent(Graphics g) { 
                Graphics2D g2d = (Graphics2D) g;

                GeneralPath theShape = new GeneralPath();
                theShape.moveTo(0, 0);
                theShape.lineTo(2, 1);
                theShape.lineTo(1, 0);
                theShape.closePath();

                g2d.scale(100, 100);
                g2d.setStroke(new BasicStroke(0.01f));
                g2d.draw(theShape);
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setVisible(true);
    }
}