import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                ArcsPanel arcPanel = new ArcsPanel();
                StillClock clockPanel = new StillClock();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(0, 2));
                frame.add(arcPanel);
                frame.add(clockPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Engine engine = new Engine();
                engine.add(arcPanel);
                engine.add(clockPanel);
                engine.start();
            }
        });
    }

    public class Engine {

        private List<Animatable> animatables;
        private Timer timer;

        public Engine() {
            animatables = new ArrayList<>(4);
            timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Animatable animatable : animatables) {
                        animatable.updateAnimatedState();
                    }
                }
            });
        }

        public void add(Animatable animatable) {
            animatables.add(animatable);
        }

        public void start() {
            timer.start();
        }

        public void stop() {
            timer.stop();
        }
    }

    public interface Animatable {

        public void updateAnimatedState();
    }

    public static class ArcsPanel extends JPanel implements Animatable {

        protected static final float DELTA = 1.0f;
        private float angle = 0;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();

            int xCenter = getWidth() / 2;
            int yCenter = getHeight() / 2;
            int radius = (int) (Math.min(getWidth(), getHeight()) * 0.4);

            g2d.setTransform(AffineTransform.getRotateInstance(Math.toRadians(angle), xCenter, yCenter));

            int x = xCenter - radius;
            int y = yCenter - radius;

            g2d.fillArc(x, y, 2 * radius, 2 * radius, 0, 30);
            g2d.fillArc(x, y, 2 * radius, 2 * radius, 90, 30);
            g2d.fillArc(x, y, 2 * radius, 2 * radius, 180, 30);
            g2d.fillArc(x, y, 2 * radius, 2 * radius, 270, 30);
            g2d.dispose();
        }

        @Override
        public void updateAnimatedState() {
            angle += DELTA;
            repaint();
        }
    }

    public class StillClock extends JPanel implements Animatable {

        private int hour;
        private int minute;
        private int second;

        public StillClock() {
            setCurrentTime();
        }

        public StillClock(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Initialize clock parameters
            int clockRadius
                            = (int) (Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
            int xCenter = getWidth() / 2;
            int yCenter = getHeight() / 2;

            // Draw circle
            g.setColor(Color.black);
            g.drawOval(xCenter - clockRadius, yCenter - clockRadius,
                            2 * clockRadius, 2 * clockRadius);
            g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
            g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
            g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
            g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

            // Draw second hand
            int sLength = (int) (clockRadius * 0.8);
            int xSecond = (int) (xCenter + sLength
                            * Math.sin(second * (2 * Math.PI / 60)));
            int ySecond = (int) (yCenter - sLength
                            * Math.cos(second * (2 * Math.PI / 60)));
            g.setColor(Color.red);
            g.drawLine(xCenter, yCenter, xSecond, ySecond);

            // Draw minute hand
            int mLength = (int) (clockRadius * 0.65);
            int xMinute = (int) (xCenter + mLength
                            * Math.sin(minute * (2 * Math.PI / 60)));
            int yMinute = (int) (yCenter - mLength
                            * Math.cos(minute * (2 * Math.PI / 60)));
            g.setColor(Color.blue);
            g.drawLine(xCenter, yCenter, xMinute, yMinute);

            // Draw hour hand
            int hLength = (int) (clockRadius * 0.5);
            int xHour = (int) (xCenter + hLength
                            * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
            int yHour = (int) (yCenter - hLength
                            * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
            g.setColor(Color.green);
            g.drawLine(xCenter, yCenter, xHour, yHour);
        }

        public void setCurrentTime() {
            // Construct a calendar for the current date and time
            Calendar calendar = new GregorianCalendar();

            // Set current hour, minute and second
            this.hour = calendar.get(Calendar.HOUR_OF_DAY);
            this.minute = calendar.get(Calendar.MINUTE);
            this.second = calendar.get(Calendar.SECOND);
        }

        @Override
        public void updateAnimatedState() {
            setCurrentTime();
            repaint();
        }
    }
}