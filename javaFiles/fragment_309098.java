import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test extends JFrame implements MouseListener {

    private JPanel panel = new JPanel();

    public Test() {
        ConnectTheDots dots = new ConnectTheDots();
        setGlassPane(dots);
        dots.setVisible(true);
        panel.setLayout(new GridLayout(2, 2));

        panel.add(createLabel(Color.RED));
        panel.add(createLabel(Color.BLUE));
        panel.add(createLabel(Color.GREEN));
        panel.add(createLabel(Color.ORANGE));

        panel.addMouseListener(this);

        this.add(panel);
    }

    private Component pressComponent;
    private Component releaseComponent;

    public void mousePressed(MouseEvent e) {
        pressComponent = panel.getComponentAt(new Point(e.getX(), e.getY()));
    }

    public void mouseReleased(MouseEvent e) {
        releaseComponent = panel.getComponentAt(new Point(e.getX(), e.getY()));
        joinTheDots();
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    protected void joinTheDots() {

        Rectangle bounds = pressComponent.getBounds();
        Point startPoint = centerOf(bounds);
        bounds = releaseComponent.getBounds();
        Point endPoint = centerOf(bounds);

        ((ConnectTheDots) getGlassPane()).drawLine(startPoint, endPoint);

    }

    protected Point centerOf(Rectangle bounds) {

        return new Point(
                        bounds.x + (bounds.width / 2),
                        bounds.y + (bounds.height / 2));

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Test frame = new Test();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    protected JLabel createLabel(Color background) {
        JLabel label = new JLabel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }
        };
        label.setOpaque(true);
        label.setBackground(background);
        return label;
    }

    public class ConnectTheDots extends JPanel {

        private Point startPoint;
        private Point endPoint;

        public ConnectTheDots() {
            setOpaque(false);
        }

        public void drawLine(Point startPoint, Point endPoint) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (startPoint != null && endPoint != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                Line2D line = new Line2D.Double(startPoint, endPoint);
                g2d.setColor(Color.BLACK);
                g2d.draw(line);
                g2d.dispose();
            }
        }

    }

}