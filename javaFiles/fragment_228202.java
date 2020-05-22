import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class DrawCar extends JPanel{
    private static final int D_W = 400;
    private static final int D_H = 400;

    List<Car> cars;
    public DrawCar() {
        cars = new ArrayList<>();
        cars.add(new Car(100, 300));
        cars.add(new Car(200, 100));

        Timer timer = new Timer(50, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                for (Car car : cars) {
                    car.move();
                    repaint();
                }
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars) {
            car.drawCar(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    public class Car {
        private static final int INCREMENT = 5;
        int x, y;
        public Car(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public void drawCar(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, 100, 30);
            g.setColor(Color.BLACK); // body
            g.fillOval(x + 15, y + 20, 15, 15); // wheel
            g.fillOval(x + 60, y + 20, 15, 15); // wheel
            g.fillRect(x + 15, y - 20, 60, 20); // top
        }

        public void move() {
            if (x == D_W) {
                x = 0;
            } else {
                x += INCREMENT;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new DrawCar());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}