import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @see https://stackoverflow.com/a/14887457/230513
 * @see https://stackoverflow.com/questions/5617027
 */

public class FleetPanel extends JPanel {

    private static final Random random = new Random();
    private final MapPanel map = new MapPanel();
    private final JPanel control = new JPanel();
    private final List<CabPanel> fleet = new ArrayList<CabPanel>();
    private final Timer timer = new Timer(200, null);

    public FleetPanel() {
        super(new BorderLayout());
        fleet.add(new CabPanel("Cab #1", Hue.Cyan));
        fleet.add(new CabPanel("Cab #2", Hue.Magenta));
        fleet.add(new CabPanel("Cab #3", Hue.Yellow));
        control.setLayout(new GridLayout(0, 1));
        for (CabPanel cp : fleet) {
            control.add(cp);
            timer.addActionListener(cp.listener);
        }
        this.add(map, BorderLayout.CENTER);
        this.add(control, BorderLayout.SOUTH);
    }

    public void start() {
        timer.start();
    }

    private class CabPanel extends JPanel {

        private static final String format = "000000";
        private final DecimalFormat df = new DecimalFormat(format);
        private JLabel name = new JLabel("", JLabel.CENTER);
        private Point point = new Point();
        private JLabel position = new JLabel(toString(point), JLabel.CENTER);
        private int blocks;
        private JLabel odometer = new JLabel(df.format(0), JLabel.CENTER);
        private final JComboBox colorBox = new JComboBox();
        private final JButton reset = new JButton("Reset");
        private final ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int ds = random.nextInt(3) - 1;
                if (random.nextBoolean()) {
                    point.x += ds;
                } else {
                    point.y += ds;
                }
                blocks += Math.abs(ds);
                update();
            }
        };

        public CabPanel(String s, Hue hue) {
            super(new GridLayout(1, 0));
            name.setText(s);
            this.setBackground(hue.getColor());
            this.add(map, BorderLayout.CENTER);
            for (Hue h : Hue.values()) {
                colorBox.addItem(h);
            }
            colorBox.setSelectedIndex(hue.ordinal());
            colorBox.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Hue h = (Hue) colorBox.getSelectedItem();
                    CabPanel.this.setBackground(h.getColor());
                    update();
                }
            });
            reset.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    point.setLocation(0, 0);
                    blocks = 0;
                    update();
                }
            });
            this.add(name);
            this.add(odometer);
            this.add(position);
            this.add(colorBox);
            this.add(reset);
        }

        private void update() {
            position.setText(CabPanel.this.toString(point));
            odometer.setText(df.format(blocks));
            map.repaint();
        }

        private String toString(Point p) {
            StringBuilder sb = new StringBuilder();
            sb.append(Math.abs(p.x));
            sb.append(p.x < 0 ? " W" : " E");
            sb.append(", ");
            sb.append(Math.abs(p.y));
            sb.append(p.y < 0 ? " N" : " S");
            return sb.toString();
        }
    }

    private class MapPanel extends JPanel {

        private static final int SIZE = 16;

        public MapPanel() {
            this.setPreferredSize(new Dimension(32 * SIZE, 32 * SIZE));
            this.setBackground(Color.lightGray);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
            int w = this.getWidth();
            int h = this.getHeight();
            g2d.setColor(Color.gray);
            for (int col = SIZE; col <= w; col += SIZE) {
                g2d.drawLine(col, 0, col, h);
            }
            for (int row = SIZE; row <= h; row += SIZE) {
                g2d.drawLine(0, row, w, row);
            }

            for (CabPanel cp : fleet) {
                Point p = cp.point;
                int x = SIZE * (p.x + w / 2 / SIZE) - SIZE / 2;
                int y = SIZE * (p.y + h / 2 / SIZE) - SIZE / 2;
                g2d.setColor(cp.getBackground());
                g2d.fillOval(x, y, SIZE, SIZE);
            }
        }
    }

    public enum Hue {

        Cyan(Color.cyan), Magenta(Color.magenta), Yellow(Color.yellow),
        Red(Color.red), Green(Color.green), Blue(Color.blue),
        Orange(Color.orange), Pink(Color.pink);
        private final Color color;

        private Hue(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
    }

    private static void display() {
        JFrame f = new JFrame("Dispatch");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FleetPanel fp = new FleetPanel();
        f.add(fp);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        fp.start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                display();
            }
        });
    }
}