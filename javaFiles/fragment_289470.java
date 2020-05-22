import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class RotatingLabel extends JLabel {
    private static final long serialVersionUID = 474652899660954020L;
    private final int circleCenterX;
    private final int circleCenterY;
    private final int radius;
    private double theta;
    private final double thetaIncrement;

    public RotatingLabel(String text, //
            int circleCenterX, int circleCenterY, int radius, //
            double initialTheta, double thetaIncrement) {
        super(text);
        this.circleCenterX = circleCenterX;
        this.circleCenterY = circleCenterY;
        this.radius = radius;
        this.theta = initialTheta;
        this.thetaIncrement = thetaIncrement;
        rotate();
    }

    public void rotate() {
        setBounds( //
                this.circleCenterX - (int) (Math.sin(this.theta) * this.radius), //
                this.circleCenterY - (int) (Math.cos(this.theta) * this.radius), //
                (int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight());
        this.theta -= this.thetaIncrement;
    }

    public static void main(String[] args) {
        double initialTheta = Math.toRadians(0); // start north
        // double initialTheta = Math.toRadians(90); // start west
        // double initialTheta = Math.toRadians(180); // start south
        // double initialTheta = Math.toRadians(270); // start east

        final RotatingLabel label = new RotatingLabel("Foo Bar", //
                450, // circleCenterX
                325, // circleCenterY
                300, // radius
                initialTheta, //
                0.005); // thetaIncrement

        JFrame frame = new JFrame();
        frame.setSize(new Dimension(800, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.setVisible(true);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        label.rotate();
                    }
                });
            }
        }, 0, 1000l / 60l); // 60 frames per second
    }
}