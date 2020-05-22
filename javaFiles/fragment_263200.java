import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseTracker extends JPanel {
    static ArrayList<Double> xL = new ArrayList<Double>();
    static ArrayList<Double> yL = new ArrayList<Double>();

    public static void main(String args[]) throws InterruptedException {
        JFrame frame = new JFrame();

        frame.getContentPane().add(new MouseTracker());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setVisible(true);

        Timer time = new Timer();
        time.schedule(new TimerTask() {
            public void run() {
                String coords = getCoords();
                System.out.println(coords);
                frame.getContentPane().repaint();
            }
        }, 0, 250);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();

        for (int i = 0; i < xL.size(); i++) {

            x.add(xL.get(i).intValue());
            y.add(yL.get(i).intValue());

        }

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.red);

        for (int i = 0; i < xL.size() - 1; i++) {

            g2d.drawLine(x.get(i), y.get(i), x.get(i + 1), y.get(i + 1));

        }

    }

    public static String getCoords() {
        double xCoord = MouseInfo.getPointerInfo().getLocation().getX();
        double yCoord = MouseInfo.getPointerInfo().getLocation().getY();

        xL.add(xCoord);
        yL.add(yCoord);

        String coords = Double.toString(xCoord) + " : "
                + Double.toString(yCoord);
        return coords;
    }
}