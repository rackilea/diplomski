import javax.swing.*;
import java.awt.*;

public class Circles extends JFrame {

    public Circles() throws HeadlessException {
        this.setLayout(new BorderLayout());
        final Dimension dimension = new Dimension(600, 600);
        this.setSize(new Dimension(dimension.width + 50, dimension.height + 50));
        this.add(new TargetPanel(dimension), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Circles circles = new Circles();
        circles.setLocationRelativeTo(null);
        circles.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        circles.setVisible(true);
    }
}


class TargetPanel extends JPanel {

    public TargetPanel(Dimension dimension) {
        this.setPreferredSize(dimension);
    }//end constructor

    public void paintComponent(Graphics g) {

        Color blue = new Color(0, 100, 0);
        Color yellow = new Color(100, 0, 0);

        super.paintComponent(g);
        int dimension = this.getPreferredSize().width;
        int partition = 75;

        drawCircle(g, Color.WHITE, Color.BLACK, dimension);
    }//end draw circle

    private void drawCircle(Graphics g, Color blue, Color yellow, int dimension) {

        g.setColor(Color.WHITE);
        final int yCenter = (getHeight() - (dimension)) / 2;
        final int xCenter = (getWidth() - (dimension)) / 2;
        g.fillOval(xCenter, yCenter, dimension, dimension);
        g.setColor(Color.BLACK);
        g.drawOval(xCenter, yCenter, dimension, dimension);

        dimension -= 30;
        g.drawOval((getWidth() - (dimension)) / 2, (getHeight() - (dimension)) / 2, dimension, dimension);

    }//end drawCircle

}//end main